package com.project.action;

import com.project.entity.UserEntity;

/**
 * 用户请求类
 * @Created: 何航
 * @Date: 2021/5/14
 * @Description:
 */
public class UserAction extends BaseAction<UserEntity>{

    // 用户登录
    public String login(){
        model = userService.login(model);
        if (model == null){
            session.put("error","登录失败！");
            return "login";
        }else {
            session.put("user",model);
            return session.get("goUrl")==null ? "index.jsp" : "goUrl";
        }
    }

}
