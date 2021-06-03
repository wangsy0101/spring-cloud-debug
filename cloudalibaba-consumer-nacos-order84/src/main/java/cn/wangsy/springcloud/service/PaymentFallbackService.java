package cn.wangsy.springcloud.service;

import cn.wangsy.springcloud.entities.CommonResult;
import cn.wangsy.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * Created by wangsy on 2021/6/1
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "fallback");
    }
}
