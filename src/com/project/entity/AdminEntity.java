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
 * 管理员实体类
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(exclude = "categoryEntities")
public class AdminEntity implements Serializable {
    private static final long serialVersionUID = 4062884371204711429L;
    /** 管理员编号 */
    private int id;
    /** 管理员登录名 */
    private String login;
    /** 管理员姓名 */
    private String name;
    /** 管理员密码 */
    private String pass;
    /** 商品类别集合 */
    private List<CategoryEntity> categoryEntities = new ArrayList<>();
}
