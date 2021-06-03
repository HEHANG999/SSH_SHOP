package com.project.service;

import com.project.entity.BackData;
import com.project.entity.SendData;

import java.util.Map;

/**
 * �ױ�֧��ҵ��ӿ�
 * @Created: �κ�
 * @Date: 2021/5/17
 * @Description:
 */
public interface PayService {

    /**
     * �Ѽ��ܺ����Ϣ�洢��requestMap��
     * @param request ����
     * @param sendData ֧��ʵ��
     * @return ������Ϣ
     */
    Map<String, Object> saveDataToRequest(Map<String, Object> request, SendData sendData);

    //�ѷ��ص����ݽ��м��ܵõ����ģ����봫���������ıȽϣ������Ǻ�������ʵ�֣�
    public boolean checkBackData(BackData backData);

}
