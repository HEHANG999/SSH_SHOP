package com.project.action;


import com.project.entity.BackData;
import com.project.entity.OrderEntity;
import com.project.entity.SendData;
import com.project.entity.UserEntity;
import org.apache.struts2.interceptor.ParameterAware;

import java.util.Map;

/**
 * 易宝支付请求类
 * @Created: 何航
 * @Date: 2021/5/17
 * @Description:
 */
public class PayAction extends BaseAction<Object> implements ParameterAware {

    //定义一个Map接收request的请求参数
    private Map<String, String[]> parameters;
    @Override
    public void setParameters(Map<String, String[]> map) {
        this.parameters = map;
    }
    /**在struts-default.xml文中，ServletConfig拦截器在ModelDriven之前先执行，所以我们在注入model的时候，
     request参数已经有了，这样我们就可以在getModel()方法中通过参数来判断是哪个请求了*/
    @Override
    public Object getModel() {
        //付款的时候有支付通道编码的参数(pd_FrpId)，返回的时候没有
        //这样我们就可以通过该参数判断是支付还是返回了
        if(parameters.get("pd_FrpId") != null) {
            model = new SendData();
        } else {
            model = new BackData();
        }
        return model;
    }

    public String goBank() {
        //对应发送的model：SendData
        SendData sendData = (SendData)model;

        //1. 补全参数:P2 p3 pd Pa，需要从session中获取
        OrderEntity order = (OrderEntity) session.get("oldForder");
        UserEntity user = (UserEntity) session.get("user");
        sendData.setP2_Order(String.valueOf(order.getId())); //商户订单号
        sendData.setP3_Amt(order.getTotal().toString()); //支付金额
        sendData.setPa_MP(user.getEmail() + "," + user.getPhone()); //商户扩展信息
        //2. 对参数进行追加
        //3. 加密获取签名
        //4. 存储到request域中
        payService.saveDataToRequest(request, sendData); //2,3,4的业务逻辑交给service层来处理
        //5. 跳转到支付页面
        return "pay";
    }

    //接收返回的数据的方法
    public void backBank() {
        BackData backData = (BackData)model;
        System.out.println(model);
        boolean isOK = payService.checkBackData(backData);
        if(isOK) {
            //1. 更新订单状态,参数是自己根据数据库中的情况传进去的，用来测试
            orderService.updateStatusById(Integer.parseInt(backData.getR6_Order()), 2);
            //2. 根据user邮箱地址，发送邮件
            //3. 发送手机短信
            System.out.println("----success!!----");
        } else {
            System.out.println("----false!!!----");
        }
    }

}
