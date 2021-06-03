package com.project.action;

import com.project.entity.ItemEntity;
import com.project.entity.OrderEntity;
import com.project.entity.StatusEntity;
import com.project.entity.UserEntity;

/**
 * ����������
 * @Created: �κ�
 * @Date: 2021/5/14
 * @Description:
 */
public class OrderAction extends BaseAction<OrderEntity>{

    @Override
    public OrderEntity getModel() {
        model = (OrderEntity) session.get("order");
        return model;
    }

    // ��Ӷ���
    public String save(){

        // 1����Ӷ���״̬
        StatusEntity status = new StatusEntity();
        statusService.save(status);

        // 2����Ӷ�����3��ͨ�������Զ���ӹ����
        model.setUserEntity((UserEntity)session.get("user"));
        model.setStatusEntity(status);
        orderService.save(model);

        //��ʱ���ﳵ�Ѿ���⣬��ôԭ��session�еĹ��ﳵ��Ӧ�����
        session.put("oldForder", session.get("order"));//�Ƚ�ԭ���Ĺ��ﳵ��Ϣ������������Ϊ���渶���ʱ����Ҫ�����Ϣ
        session.put("order", new OrderEntity());//newһ���µĿչ��ﳵ���൱������˹��ﳵ���������Է����û�����~
        return "bank";
    }

}
