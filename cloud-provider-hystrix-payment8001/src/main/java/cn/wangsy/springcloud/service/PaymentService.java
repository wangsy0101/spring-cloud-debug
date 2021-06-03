package cn.wangsy.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangsy on 2021/5/25
 */
@Service
public class PaymentService {


    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问
     * HystrixCommand:一旦调用服务方法失败并抛出了错误信息后,会自动调用@HystrixCommand标注好的fallbckMethod调用类中的指定方法
     * execution.isolation.thread.timeoutInMilliseconds:线程超时时间3秒钟
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "payment_TimeOutHandler",
                    commandProperties = {
                        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
                    },
                    threadPoolProperties = {
                        @HystrixProperty(name = "coreSize", value = "100"),
                        // @HystrixProperty(name = "maximumSize", value = "100")
                    }
    )
    public String paymentInfo_TimeOut(Integer id) {
        // int age = 10 / 0;

        int timeNumber = 2000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" +
                "O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
    }

    /**
     * 兜底方案
     *
     * @param id
     * @return
     */
    public String payment_TimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " 系统繁忙或运行错误,请稍后重试,id:" + id + "\t" + "o(╥﹏╥)o";
    }


    //======服务熔断=======

    /**
     * 在10秒窗口期中10次请求有6次是请求失败的,断路器将起作用
     * @param id
     * @return
     */
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {    //  HystrixCommandProperties.class
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数，如果滚动时间窗口（以下配置10秒）内，仅仅收到9个请求，即使这9个请求全部失败了，断路器也不会打开。
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期/时间范文，设置断路器打开之后的休眠时间窗口，休眠时间窗口结束后，
            // 会将断路器置为“半开”状态，尝试熔断的请求命令，如果依然失败，断路器继续保持“打开”状态，如果成功就设置为“关闭”状态。
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率达到多少后跳闸，该属性用来设置在滚动时间窗口中，在请求数量超过 circuitBreaker.requestVolumeThreshold 的情况下，
            // 如果错误的请求数的百分比超过60，就把断路器设置为“打开”状态，否则就设置为“关闭”状态。
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    }
    )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id不能是负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功, 流水号:" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数,请稍后重试,o(╥﹏╥)o id:" + id;
    }

}
