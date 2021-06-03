package com.project.service;

import com.project.entity.OrderEntity;

/**
 * ����ҵ��ӿ�
 * @Created: �κ�
 * @Date: 2021/5/13
 * @Description:
 */
public interface OrderService extends BaseService<OrderEntity>{

    /**
     * ���㶩���ܼ۸�
     * @param order ����
     * @return �ܼ۸�
     */
    double priceTotal(OrderEntity order);

    /**
     * ���ݶ�����ţ����¶���״̬
     * @param id �������
     * @param sid ״̬���
     */
    void updateStatusById(int id, int sid);

}
