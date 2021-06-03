package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单状态表
 * @Created: 何航
 * @Date: 2021/5/13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StatusEntity implements Serializable {
    private static final long serialVersionUID = -6718153857881427544L;
    /** 状态编号 */
    private int id;
    /** 订单状态 */
    private String status = "已下单";
    /** 订单集合 */
    @ToString.Exclude
    private List<OrderEntity> orderEntities = new ArrayList<>();
}
