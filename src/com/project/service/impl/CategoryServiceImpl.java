package com.project.service.impl;

import com.project.entity.CategoryEntity;
import com.project.service.CategoryService;

import java.util.List;

/**
 * 商品类别业务接口实现类
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
public class CategoryServiceImpl extends BaseServiceImpl<CategoryEntity> implements CategoryService {

    @Override
    public void deleteByIds(String ids) {
        String hql = "delete from CategoryEntity c where c.id in (" + ids + ")";
        getSession().createQuery(hql).executeUpdate();
    }

    @Override
    public List<CategoryEntity> queryByHot(int hot) {
        String hql = "from CategoryEntity c where c.hot=:hot";
        return getSession().createQuery(hql)
                .setParameter("hot",hot)
                .list();
    }

    @Override
    public List<CategoryEntity> queryJoinAdmin(String type, int page, int size) {
        String hql = "from CategoryEntity c left join fetch c.adminEntity where c.type like:type";
        return getSession().createQuery(hql)
                .setParameter("type", "%"+type+"%")
                .setFirstResult((page-1) * size) // 从第几个开始显示
                .setMaxResults(size)// 显示几个
                .list();
    }

    @Override
    public Long getCount(String type) {
        String hql = "select count(c) from CategoryEntity c where c.type like :type";
        return (Long) getSession().createQuery(hql)
                .setParameter("type", "%" + type + "%")
                .uniqueResult(); //返回一条记录:总记录数
    }
}
