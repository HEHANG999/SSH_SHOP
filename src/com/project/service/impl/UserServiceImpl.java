package com.project.service.impl;

import com.project.entity.UserEntity;
import com.project.service.UserService;

/**
 * 用户业务接口实现类
 * @Created: 何航
 * @Date: 2021/5/14
 * @Description:
 */
public class UserServiceImpl  extends BaseServiceImpl<UserEntity> implements UserService {

    @Override
    public UserEntity login(UserEntity user) {
        String hql = "from UserEntity u where u.login=:login and u.pass=:pass";
        return (UserEntity) getSession().createQuery(hql)
                .setParameter("login", user.getLogin())
                .setParameter("pass", user.getPass())
                .uniqueResult();
    }

}
