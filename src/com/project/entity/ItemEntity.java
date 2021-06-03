package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 购物项实体类
 * @Created: 何航
 * @Date: 2021/5/13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ItemEntity implements Serializable {
    private static final long serialVersionUID = 76977469185758225L;
    /** 购物项编号 */
    private int id;
    /** 购买商品的名称 */
    private String name;
    /** 购买商品的价格 */
    private double price;
    /** 购买数量 */
    private int number;
    /** 所属商品 */
    @ToString.Exclude
    private ProductEntity productEntity;
    /** 所属订单 */
    @ToString.Exclude
    private OrderEntity orderEntity;
}
