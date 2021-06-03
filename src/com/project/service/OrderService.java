package com.project.service;

import com.project.entity.OrderEntity;

/**
 * 订单业务接口
 * @Created: 何航
 * @Date: 2021/5/13
 * @Description:
 */
public interface OrderService extends BaseService<OrderEntity>{

    /**
     * 计算订单总价格
     * @param order 订单
     * @return 总价格
     */
    double priceTotal(OrderEntity order);

    /**
     * 根据订单编号，更新订单状态
     * @param id 订单编号
     * @param sid 状态编号
     */
    void updateStatusById(int id, int sid);

}
