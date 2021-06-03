package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * �ױ�֧��ʵ��
 * @Created: �κ�
 * @Date: 2021/5/17
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SendData implements Serializable {
    private static final long serialVersionUID = 5671110801680205038L;
    //(*)��ʾ�����ֶ�
    /** ҵ������(*)���̶�Ϊ:Buy */
    private String p0_Cmd;
    /** �̻����(*) */
    private String p1_MerId;
    /** �̻������� */
    private String p2_Order;
    /** ֧����� */
    private String p3_Amt;
    /** ���ױ���(*) */
    private String p4_Cur;
    /** ��Ʒ���� */
    private String p5_Pid;
    /** ��Ʒ���� */
    private String p6_Pcat;
    /** ��Ʒ���� */
    private String p7_Pdesc;
    /** �̻�����֧���ɹ����ݵĵ�ַ */
    private String p8_Url;
    /** �ͻ���ַ */
    private String p9_SAF;
    /** �̻���չ��Ϣ */
    private String pa_MP;
    /** ֧��ͨ�����룬������ */
    private String pd_FrpId;
    /** Ӧ����� */
    private String pr_NeedResponse;
}
