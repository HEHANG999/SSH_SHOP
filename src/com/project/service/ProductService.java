package com.project.service;

import com.project.entity.ProductEntity;

import java.util.List;

/**
 * 商品业务接口
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
public interface ProductService extends BaseService<ProductEntity> {

    /**
     * 批量删除商品
     * @param ids 商品编号集合
     */
    void deleteByIds(String ids);

    /**
     * 查询商品信息，级联类别
     * @param name 商品名称
     * @param page 当前页
     * @param size 每页显示数
     * @return 商品集合
     */
    List<ProductEntity> queryJoinCategory(String name, int page, int size);

    /**
     * 根据关键字查询总记录数
     * @param name 商品名称
     * @return 总记录数
     */
    Long getCount(String name);

    /**
     * 根据热点类别查询推荐商品（查询前4个）
     * @param cid 类别编号
     * @return 商品集合
     */
    List<ProductEntity> queryByCategoryId(int cid);
}
