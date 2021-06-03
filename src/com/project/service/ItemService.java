package com.project.service;

import com.project.entity.ItemEntity;
import com.project.entity.OrderEntity;
import com.project.entity.ProductEntity;

import java.util.List;

/**
 * ������ҵ��ӿ�
 * @Created: �κ�
 * @Date: 2021/5/13
 * @Description:
 */
public interface ItemService extends BaseService<ItemEntity> {

    /**
     * ����ƷתΪ������
     * @param product ��Ʒ
     * @return ������
     */
    ItemEntity productToItem(ProductEntity product);

    /**
     * ��ӹ�����ж��ظ����������µĶ���
     * @param order ����
     * @param product ��Ʒ
     * @return ����
     */
    OrderEntity addItem(OrderEntity order, ProductEntity product);

    /**
     * ������Ʒid������Ʒ����
     * @param item ������
     * @param order ����
     * @return ����
     */
    OrderEntity updateItem(ItemEntity item, OrderEntity order);

    /**
     * ��ѯ�ȵ���Ʒ��������
     * @param number ����������
     * @return ����
     */
    List<Object> querySale(int number);

}
