package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 * @Created: 何航
 * @Date: 2021/5/13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 8469397180091786013L;
    /** 订单编号 */
    private int id;
    /** 收件人姓名 */
    private String name;
    /** 收件人电话 */
    private String phone;
    /** 配送信息 */
    private String remark;
    /** 下单日期 */
    private Timestamp date = new Timestamp(new Date().getTime());
    /** 订单总金额 */
    private Double total;
    /** 收件人邮编 */
    private String post;
    /** 收件人地址 */
    private String address;
    /** 订单状态 */
    @ToString.Exclude
    private StatusEntity statusEntity;
    /** 会员编号 */
    @ToString.Exclude
    private UserEntity userEntity;
    /** 购物项集合 */
    @ToString.Exclude
    private List<ItemEntity> itemEntities = new ArrayList<>();
}
