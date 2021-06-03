package cn.wangsy.springcloud.controller;

import cn.wangsy.springcloud.entities.CommonResult;
import cn.wangsy.springcloud.entities.Payment;
import cn.wangsy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangsy on 2021/5/24
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    /**
     * 新增
     * postman http://localhost:8001/payment/create?serial=200
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果: " + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功, serverPort:" + serverPort, result);
        }

        return new CommonResult(444, "插入数据库失败", null);
    }



    /**
     * 查询
     * http://localhost:8001/payment/get/31
     *
     * @param id
     * @return
     */
    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果: " + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功, serverPort:" + serverPort, payment);
        }
        return new CommonResult(444, "没有对应记录, 查询ID:" + id, null);
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    /**
     * 链路跟踪
     *
     * @return
     */
    @GetMapping(value = "/payment/zipkin")
    public String paymentZipkin() {
        return "hi,i'am paymentZipkin, O(∩_∩)O哈哈~ " + serverPort;
    }

}
