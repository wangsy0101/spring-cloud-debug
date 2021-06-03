package cn.wangsy.springcloud.controller;

import cn.wangsy.springcloud.entities.CommonResult;
import cn.wangsy.springcloud.entities.Payment;
import cn.wangsy.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by wangsy on 2021/5/25
 */
@RestController
@Slf4j
public class OrderFeignClientController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon, 客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }

}
