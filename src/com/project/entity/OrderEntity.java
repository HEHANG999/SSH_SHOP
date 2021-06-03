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
 * ����ʵ����
 * @Created: �κ�
 * @Date: 2021/5/13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 8469397180091786013L;
    /** ������� */
    private int id;
    /** �ռ������� */
    private String name;
    /** �ռ��˵绰 */
    private String phone;
    /** ������Ϣ */
    private String remark;
    /** �µ����� */
    private Timestamp date = new Timestamp(new Date().getTime());
    /** �����ܽ�� */
    private Double total;
    /** �ռ����ʱ� */
    private String post;
    /** �ռ��˵�ַ */
    private String address;
    /** ����״̬ */
    @ToString.Exclude
    private StatusEntity statusEntity;
    /** ��Ա��� */
    @ToString.Exclude
    private UserEntity userEntity;
    /** ������� */
    @ToString.Exclude
    private List<ItemEntity> itemEntities = new ArrayList<>();
}
