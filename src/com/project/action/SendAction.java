package com.project.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 系统请求类
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description: 用来处理系统其它请求
 */
public class SendAction extends ActionSupport {

    public String execute() {
        return "send";
    }

}
