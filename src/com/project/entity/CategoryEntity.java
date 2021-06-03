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
 * 类别实体类
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(exclude = "productEntities")
public class CategoryEntity implements Serializable {
    private static final long serialVersionUID = -2872127168101705684L;
    /** 类别编号 */
    private int id;
    /** 类别类型 */
    private String type;
    /** 是否为热点类型，0否1是，为热点类型才可能展示在首页 */
    private int hot = 0;
    /** 管理员 */
    private AdminEntity adminEntity;
    /** 商品集合 */
    private List<ProductEntity> productEntities = new ArrayList<>();
}
