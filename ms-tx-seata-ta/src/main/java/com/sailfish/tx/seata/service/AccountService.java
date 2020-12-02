package com.sailfish.tx.seata.service;

/**
 * @author XIAXINYU3
 * @date 2020/12/2
 */
public interface AccountService {

    /**
     * 扣除余额
     *
     * @param userId 用户编号
     * @param price  扣减金额
     * @throws Exception 失败时抛出异常
     */
    void reduceBalance(Long userId, Integer price) throws Exception;

}
