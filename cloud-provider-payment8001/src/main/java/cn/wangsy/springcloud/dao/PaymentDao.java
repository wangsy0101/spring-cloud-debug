package cn.wangsy.springcloud.dao;

import cn.wangsy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wangsy on 2021/5/24
 */
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);


}
