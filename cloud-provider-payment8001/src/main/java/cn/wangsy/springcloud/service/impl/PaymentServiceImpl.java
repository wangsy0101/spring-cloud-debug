package cn.wangsy.springcloud.service.impl;

import cn.wangsy.springcloud.dao.PaymentDao;
import cn.wangsy.springcloud.entities.Payment;
import cn.wangsy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wangsy on 2021/5/24
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
