package com.project.service;

import com.project.entity.UserEntity;

/**
 * 用户业务接口
 * @Created: 何航
 * @Date: 2021/5/14
 * @Description:
 */
public interface UserService extends BaseService<UserEntity>{

    /**
     * 用户登录
     * @param user 用户
     * @return 登录成功返回用户
     */
    UserEntity login(UserEntity user);

}
