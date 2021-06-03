package com.project.action;

import com.project.entity.ItemEntity;
import com.project.entity.OrderEntity;
import com.project.entity.StatusEntity;
import com.project.entity.UserEntity;

/**
 * 订单请求类
 * @Created: 何航
 * @Date: 2021/5/14
 * @Description:
 */
public class OrderAction extends BaseAction<OrderEntity>{

    @Override
    public OrderEntity getModel() {
        model = (OrderEntity) session.get("order");
        return model;
    }

    // 添加订单
    public String save(){

        // 1、添加订单状态
        StatusEntity status = new StatusEntity();
        statusService.save(status);

        // 2、添加订单（3、通过级联自动添加购物项）
        model.setUserEntity((UserEntity)session.get("user"));
        model.setStatusEntity(status);
        orderService.save(model);

        //此时购物车已经入库，那么原来session中的购物车就应该清空
        session.put("oldForder", session.get("order"));//先将原来的购物车信息保存下来，因为后面付款的时候还需要相关信息
        session.put("order", new OrderEntity());//new一个新的空购物车（相当于清空了购物车），还可以方便用户再买~
        return "bank";
    }

}
