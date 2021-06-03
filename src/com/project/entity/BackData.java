package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 支付返回实体
 * @Created: 何航
 * @Date: 2021/5/17
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BackData implements Serializable {
    private static final long serialVersionUID = -6629682627530667412L;
    private String r0_Cmd;
    private String p1_MerId;
    private String r1_Code;
    private String r2_TrxId;
    private String r3_Amt;
    private String r4_Cur;
    private String r5_Pid;
    private String r6_Order;
    private String r7_Uid;
    private String r8_MP;
    private String r9_BType;
    private String hmac;
}
