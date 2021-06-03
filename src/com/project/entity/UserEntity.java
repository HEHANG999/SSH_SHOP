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
 * �û�ʵ����
 * @Created: �κ�
 * @Date: 2021/5/13
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -213332898751491477L;
    /** �û���� */
    private int id;
    /** �û���¼�� */
    private String login;
    /** �û���ʵ���� */
    private String name;
    /** �û���¼���� */
    private String pass;
    /** �û��Ա� */
    private String sex;
    /** �û��绰 */
    private String phone;
    /** �û����� */
    private String email;
    /** �������� */
    @ToString.Exclude
    private List<OrderEntity> orderEntities = new ArrayList<>();
}
