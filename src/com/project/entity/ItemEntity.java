package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ������ʵ����
 * @Created: �κ�
 * @Date: 2021/5/13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ItemEntity implements Serializable {
    private static final long serialVersionUID = 76977469185758225L;
    /** �������� */
    private int id;
    /** ������Ʒ������ */
    private String name;
    /** ������Ʒ�ļ۸� */
    private double price;
    /** �������� */
    private int number;
    /** ������Ʒ */
    @ToString.Exclude
    private ProductEntity productEntity;
    /** �������� */
    @ToString.Exclude
    private OrderEntity orderEntity;
}
