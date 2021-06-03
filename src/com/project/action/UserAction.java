package com.project.action;

import com.project.entity.UserEntity;

/**
 * �û�������
 * @Created: �κ�
 * @Date: 2021/5/14
 * @Description:
 */
public class UserAction extends BaseAction<UserEntity>{

    // �û���¼
    public String login(){
        model = userService.login(model);
        if (model == null){
            session.put("error","��¼ʧ�ܣ�");
            return "login";
        }else {
            session.put("user",model);
            return session.get("goUrl")==null ? "index.jsp" : "goUrl";
        }
    }

}
