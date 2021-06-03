package com.project.action;

import com.opensymphony.xwork2.ActionContext;
import com.project.entity.ItemEntity;
import com.project.entity.OrderEntity;
import com.project.entity.ProductEntity;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * 购物项请求类
 * @Created: 何航
 * @Date: 2021/5/14
 * @Description:
 */
public class ItemAction extends BaseAction<ItemEntity>{

    // 添加购物项
    public String addItem(){
        ProductEntity product = productService.getById(model.getProductEntity().getId());
        if (session.get("order") == null){// 判断session中是否有订单
            session.put("order",new OrderEntity());
        }
        OrderEntity order = (OrderEntity) session.get("order");
        order = itemService.addItem(order,product);
        order.setTotal(orderService.priceTotal(order));
        session.put("order",order);
        return "showCart";
    };

    // 根据商品编号更新商品数量
    public String updateItem(){
        OrderEntity order = (OrderEntity) session.get("order");
        order = itemService.updateItem(model,order);// 更新购物项，传进来的product.id被封装到了model中
        order.setTotal(orderService.priceTotal(order));
        session.put("order",order);

        inputStream = new ByteArrayInputStream(order.getTotal().toString().getBytes());// 以流的形式返回新的总价格
        return "stream";
    }

    //返回热门商品及其销售量
    public String querySale() {
        List<Object> jsonList = itemService.querySale(model.getNumber());
        //将查询出来的list放到值栈的顶端
        ActionContext.getContext().getValueStack().push(jsonList);
        return "jsonList";
    }


}
