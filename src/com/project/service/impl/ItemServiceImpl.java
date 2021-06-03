package com.project.service.impl;

import com.project.entity.ItemEntity;
import com.project.entity.OrderEntity;
import com.project.entity.ProductEntity;
import com.project.service.ItemService;

import java.util.List;

/**
 * 购物项业务接口实现类
 * @Created: 何航
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
        // 是否购物项重复
        boolean isHave = false;
        ItemEntity item = productToItem(product);

        if (order.getItemEntities()!=null && order.getItemEntities().size()!=0){
            for(ItemEntity old : order.getItemEntities()){
                if (old.getProductEntity().getId() == item.getProductEntity().getId()){// 当前购物项中是否有商品重复
                    old.setNumber(old.getNumber() + item.getNumber());
                    isHave = true;
                    break;
                }
            }
        }
        if (!isHave){
            order.getItemEntities().add(item);// 新加购物项
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
        // 不用fecth查出来的就是两项
        String hql = "select s.name, sum(s.number) from ItemEntity s join s.productEntity group by s.productEntity.id";
        return getSession().createQuery(hql)
                .setFirstResult(0)
                .setMaxResults(number)
                .list();
    }

}
