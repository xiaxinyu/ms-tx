package com.sailfish.tx.seata.controller;

/**
 * @author XIAXINYU3
 * @date 2020/12/2
 */
import com.sailfish.tx.seata.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Integer createOrder(@RequestParam("userId") Long userId,
                               @RequestParam("productId") Long productId,
                               @RequestParam("price") Integer price) throws Exception {
        log.info("[createOrder] 收到下单请求,用户:{}, 商品:{}, 价格:{}", userId, productId, price);
        return orderService.createOrder(userId, productId, price);
    }

}