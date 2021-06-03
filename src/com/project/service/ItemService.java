package com.project.service;

import com.project.entity.ItemEntity;
import com.project.entity.OrderEntity;
import com.project.entity.ProductEntity;

import java.util.List;

/**
 * 购物项业务接口
 * @Created: 何航
 * @Date: 2021/5/13
 * @Description:
 */
public interface ItemService extends BaseService<ItemEntity> {

    /**
     * 把商品转为购物项
     * @param product 商品
     * @return 购物项
     */
    ItemEntity productToItem(ProductEntity product);

    /**
     * 添加购物项（判断重复），返回新的订单
     * @param order 订单
     * @param product 商品
     * @return 订单
     */
    OrderEntity addItem(OrderEntity order, ProductEntity product);

    /**
     * 根据商品id更新商品数量
     * @param item 购物项
     * @param order 订单
     * @return 订单
     */
    OrderEntity updateItem(ItemEntity item, OrderEntity order);

    /**
     * 查询热点商品的销售量
     * @param number 多少条数据
     * @return 数据
     */
    List<Object> querySale(int number);

}
