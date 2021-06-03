package com.project.action;


import com.project.entity.BackData;
import com.project.entity.OrderEntity;
import com.project.entity.SendData;
import com.project.entity.UserEntity;
import org.apache.struts2.interceptor.ParameterAware;

import java.util.Map;

/**
 * �ױ�֧��������
 * @Created: �κ�
 * @Date: 2021/5/17
 * @Description:
 */
public class PayAction extends BaseAction<Object> implements ParameterAware {

    //����һ��Map����request���������
    private Map<String, String[]> parameters;
    @Override
    public void setParameters(Map<String, String[]> map) {
        this.parameters = map;
    }
    /**��struts-default.xml���У�ServletConfig��������ModelDriven֮ǰ��ִ�У�����������ע��model��ʱ��
     request�����Ѿ����ˣ��������ǾͿ�����getModel()������ͨ���������ж����ĸ�������*/
    @Override
    public Object getModel() {
        //�����ʱ����֧��ͨ������Ĳ���(pd_FrpId)�����ص�ʱ��û��
        //�������ǾͿ���ͨ���ò����ж���֧�����Ƿ�����
        if(parameters.get("pd_FrpId") != null) {
            model = new SendData();
        } else {
            model = new BackData();
        }
        return model;
    }

    public String goBank() {
        //��Ӧ���͵�model��SendData
        SendData sendData = (SendData)model;

        //1. ��ȫ����:P2 p3 pd Pa����Ҫ��session�л�ȡ
        OrderEntity order = (OrderEntity) session.get("oldForder");
        UserEntity user = (UserEntity) session.get("user");
        sendData.setP2_Order(String.valueOf(order.getId())); //�̻�������
        sendData.setP3_Amt(order.getTotal().toString()); //֧�����
        sendData.setPa_MP(user.getEmail() + "," + user.getPhone()); //�̻���չ��Ϣ
        //2. �Բ�������׷��
        //3. ���ܻ�ȡǩ��
        //4. �洢��request����
        payService.saveDataToRequest(request, sendData); //2,3,4��ҵ���߼�����service��������
        //5. ��ת��֧��ҳ��
        return "pay";
    }

    //���շ��ص����ݵķ���
    public void backBank() {
        BackData backData = (BackData)model;
        System.out.println(model);
        boolean isOK = payService.checkBackData(backData);
        if(isOK) {
            //1. ���¶���״̬,�������Լ��������ݿ��е��������ȥ�ģ���������
            orderService.updateStatusById(Integer.parseInt(backData.getR6_Order()), 2);
            //2. ����user�����ַ�������ʼ�
            //3. �����ֻ�����
            System.out.println("----success!!----");
        } else {
            System.out.println("----false!!!----");
        }
    }

}
