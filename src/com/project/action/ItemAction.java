package com.project.action;

import com.opensymphony.xwork2.ActionContext;
import com.project.entity.ItemEntity;
import com.project.entity.OrderEntity;
import com.project.entity.ProductEntity;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * ������������
 * @Created: �κ�
 * @Date: 2021/5/14
 * @Description:
 */
public class ItemAction extends BaseAction<ItemEntity>{

    // ��ӹ�����
    public String addItem(){
        ProductEntity product = productService.getById(model.getProductEntity().getId());
        if (session.get("order") == null){// �ж�session���Ƿ��ж���
            session.put("order",new OrderEntity());
        }
        OrderEntity order = (OrderEntity) session.get("order");
        order = itemService.addItem(order,product);
        order.setTotal(orderService.priceTotal(order));
        session.put("order",order);
        return "showCart";
    };

    // ������Ʒ��Ÿ�����Ʒ����
    public String updateItem(){
        OrderEntity order = (OrderEntity) session.get("order");
        order = itemService.updateItem(model,order);// ���¹������������product.id����װ����model��
        order.setTotal(orderService.priceTotal(order));
        session.put("order",order);

        inputStream = new ByteArrayInputStream(order.getTotal().toString().getBytes());// ��������ʽ�����µ��ܼ۸�
        return "stream";
    }

    //����������Ʒ����������
    public String querySale() {
        List<Object> jsonList = itemService.querySale(model.getNumber());
        //����ѯ������list�ŵ�ֵջ�Ķ���
        ActionContext.getContext().getValueStack().push(jsonList);
        return "jsonList";
    }


}
