package com.project.action;

import com.project.entity.AdminEntity;

/**
 * 管理员请求类
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
public class AdminAction extends BaseAction<AdminEntity>{

    // 查询所有管理员
    public String query() {
        jsonList = adminService.query();
        return "jsonList";
    }


}
