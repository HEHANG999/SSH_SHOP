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
 * ����״̬��
 * @Created: �κ�
 * @Date: 2021/5/13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StatusEntity implements Serializable {
    private static final long serialVersionUID = -6718153857881427544L;
    /** ״̬��� */
    private int id;
    /** ����״̬ */
    private String status = "���µ�";
    /** �������� */
    @ToString.Exclude
    private List<OrderEntity> orderEntities = new ArrayList<>();
}
