package com.project.service;

import com.project.entity.UserEntity;

/**
 * �û�ҵ��ӿ�
 * @Created: �κ�
 * @Date: 2021/5/14
 * @Description:
 */
public interface UserService extends BaseService<UserEntity>{

    /**
     * �û���¼
     * @param user �û�
     * @return ��¼�ɹ������û�
     */
    UserEntity login(UserEntity user);

}
