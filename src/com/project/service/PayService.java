package com.project.service;

import com.project.entity.BackData;
import com.project.entity.SendData;

import java.util.Map;

/**
 * 易宝支付业务接口
 * @Created: 何航
 * @Date: 2021/5/17
 * @Description:
 */
public interface PayService {

    /**
     * 把加密后的信息存储到requestMap中
     * @param request 请求
     * @param sendData 支付实体
     * @return 数据信息
     */
    Map<String, Object> saveDataToRequest(Map<String, Object> request, SendData sendData);

    //把返回的数据进行加密得到密文，并与传回来的密文比较，（我们后面再来实现）
    public boolean checkBackData(BackData backData);

}
