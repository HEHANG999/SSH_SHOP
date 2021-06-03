package com.project.service.impl;

import com.project.entity.BackData;
import com.project.entity.SendData;
import com.project.service.PayService;
import com.project.util.DigestUtil;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * @Created: �κ�
 * @Date: 2021/5/17
 * @Description:
 */
public class PayServiceImpl implements PayService {

    /** ��Կ */
    @Value("#{prop.key}")
    private String key;

    /** �̻��˺ţ����Ƕ����ţ�*/
    @Value("#{prop.p1_MerId}")
    private String p1_MerId;

    /** ֧���ɹ��ķ��ص�ַ */
    @Value("#{prop.p8_Url}")
    private String p8_Url;

    @Override
    public Map<String, Object> saveDataToRequest(Map<String, Object> request, SendData sendData) {
        // �����˱�׷�ӵ��ַ����������ģ�
        String joinParam = joinSendDataParam(sendData);
        request.put("p0_Cmd", sendData.getP0_Cmd());
        request.put("p1_MerId", sendData.getP1_MerId());
        request.put("p2_Order", sendData.getP2_Order());
        request.put("p3_Amt", sendData.getP3_Amt());
        request.put("p4_Cur", sendData.getP4_Cur());
        request.put("p5_Pid", sendData.getP5_Pid());
        request.put("p6_Pcat", sendData.getP6_Pcat());
        request.put("p7_Pdesc", sendData.getP7_Pdesc());
        request.put("p8_Url", sendData.getP8_Url());
        request.put("p9_SAF", sendData.getP9_SAF());
        request.put("pa_MP", sendData.getPa_MP());
        request.put("pd_FrpId", sendData.getPd_FrpId());
        request.put("pr_NeedResponse", sendData.getPr_NeedResponse());
        request.put("hmac", DigestUtil.hmacSign(joinParam, key));//׷��֮���ǩ�������ģ�
        return request;
    }

    @Override
    public boolean checkBackData(BackData backData) {
        String joinParam=this.joinBackDataParam(backData);
        // ���ܺ�õ��Լ�������
        String md5 = DigestUtil.hmacSign(joinParam.toString(),key);
        // ���ĺʹ��������ıȽ�
        return md5.equals(backData.getHmac());
    }

    // ��ɷ������ݵ�׷��
    private String joinBackDataParam(BackData backData) {
        // ׷���ַ���,Ϊ������֤��׼��
        StringBuffer infoBuffer = new StringBuffer();
        infoBuffer.append(backData.getP1_MerId());
        infoBuffer.append(backData.getR0_Cmd());
        infoBuffer.append(backData.getR1_Code());
        infoBuffer.append(backData.getR2_TrxId());
        infoBuffer.append(backData.getR3_Amt());
        infoBuffer.append(backData.getR4_Cur());
        infoBuffer.append(backData.getR5_Pid());
        infoBuffer.append(backData.getR6_Order());
        infoBuffer.append(backData.getR7_Uid());
        infoBuffer.append(backData.getR8_MP());
        infoBuffer.append(backData.getR9_BType());
        return infoBuffer.toString();
    }

    // ��ȫSendData������, P2 p3 pd Pa ��ǰ̨ע�룬����Ҫ���ⲹ�ˣ��Ѿ���Action���õ���
    private SendData finishSendData(SendData sendData) {
        sendData.setP0_Cmd("Buy");
        sendData.setP1_MerId(p1_MerId);
        sendData.setP4_Cur("CNY");
        sendData.setP5_Pid("");
        sendData.setP6_Pcat("");
        sendData.setP7_Pdesc("");
        sendData.setP8_Url(p8_Url);
        sendData.setP9_SAF("0");
        sendData.setPr_NeedResponse("0");
        return sendData;
    }

    // ������ݵ�׷�ӣ�����׷�ӵ�����
    private String joinSendDataParam(SendData sendData) {
        // ������������
        sendData = this.finishSendData(sendData);
        StringBuffer infoBuffer = new StringBuffer();
        infoBuffer.append(sendData.getP0_Cmd());
        infoBuffer.append(sendData.getP1_MerId());
        infoBuffer.append(sendData.getP2_Order());
        infoBuffer.append(sendData.getP3_Amt());
        infoBuffer.append(sendData.getP4_Cur());
        infoBuffer.append(sendData.getP5_Pid());
        infoBuffer.append(sendData.getP6_Pcat());
        infoBuffer.append(sendData.getP7_Pdesc());
        infoBuffer.append(sendData.getP8_Url());
        infoBuffer.append(sendData.getP9_SAF());
        infoBuffer.append(sendData.getPa_MP());
        infoBuffer.append(sendData.getPd_FrpId());
        infoBuffer.append(sendData.getPr_NeedResponse());
        return infoBuffer.toString();
    }

}
