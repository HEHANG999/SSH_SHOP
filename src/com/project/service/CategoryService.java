package com.project.service;

import com.project.entity.CategoryEntity;

import java.util.List;

/**
 * 商品类别业务接口
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
public interface CategoryService extends BaseService<CategoryEntity>{

    /**
     * 批量删除多条商品记录
     * @param ids 商品id集合
     */
    void deleteByIds(String ids);

    /**
     * 查询商品类别为热点或非热点
     * @param hot 是否为热点，0否1是
     * @return 商品类别集合
     */
    List<CategoryEntity> queryByHot(int hot);

    /**
     * 分页查询商品类别信息，级联管理员
     * @param type 商品类型名称
     * @param page 当前页
     * @param size 每页显示数
     * @return 商品类别集合
     */
    List<CategoryEntity> queryJoinAdmin(String type, int page, int size);

    /**
     * 根据商品类型查询总记录数
     * @param type 商品类型
     * @return 总记录数
     */
    Long getCount(String type);
}
