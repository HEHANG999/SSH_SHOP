package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 易宝支付实体
 * @Created: 何航
 * @Date: 2021/5/17
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SendData implements Serializable {
    private static final long serialVersionUID = 5671110801680205038L;
    //(*)表示必填字段
    /** 业务类型(*)，固定为:Buy */
    private String p0_Cmd;
    /** 商户编号(*) */
    private String p1_MerId;
    /** 商户订单号 */
    private String p2_Order;
    /** 支付金额 */
    private String p3_Amt;
    /** 交易币种(*) */
    private String p4_Cur;
    /** 商品名称 */
    private String p5_Pid;
    /** 商品种类 */
    private String p6_Pcat;
    /** 商品描述 */
    private String p7_Pdesc;
    /** 商户接收支付成功数据的地址 */
    private String p8_Url;
    /** 送货地址 */
    private String p9_SAF;
    /** 商户扩展信息 */
    private String pa_MP;
    /** 支付通道编码，即银行 */
    private String pd_FrpId;
    /** 应答机制 */
    private String pr_NeedResponse;
}
