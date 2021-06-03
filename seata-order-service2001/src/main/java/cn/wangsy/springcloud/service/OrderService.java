package cn.wangsy.springcloud.service;

import cn.wangsy.springcloud.domain.Order;

/**
 * Created by wangsy on 2021/6/2
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
