package com.sailfish.tx.seata.service;

/**
 * @author XIAXINYU3
 * @date 2020/12/2
 */
public interface ProductService {

    /**
     * 扣减库存
     *
     * @param productId 商品 ID
     * @param amount    扣减数量
     * @throws Exception 扣减失败时抛出异常
     */
    void reduceStock(Long productId, Integer amount) throws Exception;

}