package com.project.service.impl;

import com.project.entity.ItemEntity;
import com.project.entity.OrderEntity;
import com.project.entity.ProductEntity;
import com.project.service.ItemService;

import java.util.List;

/**
 * ������ҵ��ӿ�ʵ����
 * @Created: �κ�
 * @Date: 2021/5/13
 * @Description:
 */
public class ItemServiceImpl extends BaseServiceImpl<ItemEntity> implements ItemService {

    @Override
    public ItemEntity productToItem(ProductEntity product) {
        ItemEntity item = new ItemEntity();
        item.setName(product.getName()).setPrice(product.getPrice()).setNumber(1).setProductEntity(product);
        return item;
    }

    @Override
    public OrderEntity addItem(OrderEntity order, ProductEntity product) {
        // �Ƿ������ظ�
        boolean isHave = false;
        ItemEntity item = productToItem(product);

        if (order.getItemEntities()!=null && order.getItemEntities().size()!=0){
            for(ItemEntity old : order.getItemEntities()){
                if (old.getProductEntity().getId() == item.getProductEntity().getId()){// ��ǰ���������Ƿ�����Ʒ�ظ�
                    old.setNumber(old.getNumber() + item.getNumber());
                    isHave = true;
                    break;
                }
            }
        }
        if (!isHave){
            order.getItemEntities().add(item);// �¼ӹ�����
        }


        return order;
    }

    @Override
    public OrderEntity updateItem(ItemEntity item, OrderEntity order) {
        for (ItemEntity itemEntity : order.getItemEntities()){
            if (itemEntity.getProductEntity().getId() == item.getProductEntity().getId()){
                itemEntity.setNumber(item.getNumber());
            }
        }
        return order;
    }

    @Override
    public List<Object> querySale(int number) {
        // ����fecth������ľ�������
        String hql = "select s.name, sum(s.number) from ItemEntity s join s.productEntity group by s.productEntity.id";
        return getSession().createQuery(hql)
                .setFirstResult(0)
                .setMaxResults(number)
                .list();
    }

}
