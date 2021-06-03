package cn.wangsy.springcloud.service;

/**
 * Created by wangsy on 2021/6/2
 */
public interface StorageService {

    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    void decrease(Long productId, Integer count);
}
