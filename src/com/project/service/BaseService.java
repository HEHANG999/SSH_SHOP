package com.project.service;

import java.util.List;

/**
 * 公共方法业务接口
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
public interface BaseService<T> {
    /** 增加 */
    void save(T t);
    /** 删除 */
    void delete(int id);
    /** 修改 */
    void update(T t);
    /** 按id查询 */
    T getById(int id);
    /** 查询全部 */
    List<T> query();
}
