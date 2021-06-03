package cn.wangsy.springcloud.service;

import cn.wangsy.springcloud.entities.Payment;

/**
 * Created by wangsy on 2021/5/24
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
