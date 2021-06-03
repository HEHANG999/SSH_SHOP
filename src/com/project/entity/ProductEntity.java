package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 商品实体类
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 27744047013857594L;
    /** 商品编号 */
    private int id;
    /** 商品名称 */
    private String name;
    /** 商品价格 */
    private double price;
    /** 商品图片 */
    private String pic;
    /** 商品简介 */
    private String remark;
    /** 商品详细描述 */
    private String xremark;
    /** 商品生产日期 */
    private Timestamp date;
    /** 是否为推荐商品，0否1是，推荐商品才有可能显示在商城首页 */
    private int commend;
    /** 是否为有效商品，0否1是，有效商品才有可能显示在商城首页 */
    private int open;
    /** 商品类别 */
    @ToString.Exclude
    private CategoryEntity categoryEntity;
}
