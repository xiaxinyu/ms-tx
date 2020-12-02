package com.sailfish.tx.seata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.sailfish.tx.seata.dao.OrderDao;
import com.sailfish.tx.seata.entity.OrderDO;
import com.sailfish.tx.seata.service.AccountService;
import com.sailfish.tx.seata.service.OrderService;
import com.sailfish.tx.seata.service.ProductService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XIAXINYU3
 * @date 2020/12/2
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProductService productService;

    @Override
    @DS(value = "order-ds")
    @GlobalTransactional
    public Integer createOrder(Long userId, Long productId, Integer price) throws Exception {
        // 购买数量，暂时设置为 1。
        Integer amount = 1;

        log.info("[createOrder] 当前 XID: {}", RootContext.getXID());

        // 扣减库存
        productService.reduceStock(productId, amount);

        // 扣减余额
        accountService.reduceBalance(userId, price);

        // 保存订单
        OrderDO order = new OrderDO().setUserId(userId).setProductId(productId).setPayAmount(amount * price);
        orderDao.saveOrder(order);
        log.info("[createOrder] 保存订单: {}", order.getId());

        // 返回订单编号
        return order.getId();
    }

}
