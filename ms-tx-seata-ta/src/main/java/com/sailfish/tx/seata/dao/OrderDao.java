package com.sailfish.tx.seata.dao;

import com.sailfish.tx.seata.entity.OrderDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * @author XIAXINYU3
 * @date 2020/12/2
 */
@Mapper
@Repository
public interface OrderDao {

    /**
     * 插入订单记录
     *
     * @param order 订单
     * @return 影响记录数量
     */
    @Insert("INSERT INTO orders (user_id, product_id, pay_amount) VALUES (#{userId}, #{productId}, #{payAmount})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int saveOrder(OrderDO order);

}
