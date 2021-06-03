package com.project.service.impl;

import com.project.entity.ItemEntity;
import com.project.entity.OrderEntity;
import com.project.service.OrderService;

/**
 * 订单业务接口实现类
 * @Created: 何航
 * @Date: 2021/5/14
 * @Description:
 */
public class OrderServiceImpl extends BaseServiceImpl<OrderEntity> implements OrderService {

    @Override
    public double priceTotal(OrderEntity order) {
        double total = 0;
        for (ItemEntity item : order.getItemEntities()){
            total += item.getNumber() * item.getPrice();
        }
        return total;
    }

    @Override
    public void updateStatusById(int id, int sid) {
        String hql = "update OrderEntity f set f.statusEntity.id=:sid where f.id=:id";
        getSession().createQuery(hql)
                .setParameter("sid", sid)
                .setParameter("id", id)
                .executeUpdate();
    }

}
