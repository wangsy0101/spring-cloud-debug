package cn.wangsy.springcloud.service;

import java.math.BigDecimal;

/**
 * Created by wangsy on 2021/6/2
 */
public interface AccountService {

    /**
     * 减库存
     *
     * @param userId 用户id
     * @param money  金额
     * @return
     */
    void decrease(Long userId, BigDecimal money);

}
