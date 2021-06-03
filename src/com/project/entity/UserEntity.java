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
 * 用户实体类
 * @Created: 何航
 * @Date: 2021/5/13
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -213332898751491477L;
    /** 用户编号 */
    private int id;
    /** 用户登录名 */
    private String login;
    /** 用户真实姓名 */
    private String name;
    /** 用户登录密码 */
    private String pass;
    /** 用户性别 */
    private String sex;
    /** 用户电话 */
    private String phone;
    /** 用户邮箱 */
    private String email;
    /** 订单集合 */
    @ToString.Exclude
    private List<OrderEntity> orderEntities = new ArrayList<>();
}
