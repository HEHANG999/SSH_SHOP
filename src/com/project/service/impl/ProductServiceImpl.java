package com.project.service.impl;

import com.project.entity.ProductEntity;
import com.project.service.ProductService;

import java.util.List;

/**
 * 商品业务接口实现类
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
public class ProductServiceImpl extends BaseServiceImpl<ProductEntity> implements ProductService {

    @Override
    public void deleteByIds(String ids) {
        String hql = "delete from ProductEntity p where p.id in (" + ids + ")";
        getSession().createQuery(hql).executeUpdate();
    }

    @Override
    public List<ProductEntity> queryJoinCategory(String name, int page, int size) {
        String hql = "from ProductEntity p left join fetch p.categoryEntity where p.name like :name";
        return getSession().createQuery(hql)
                .setParameter("name", "%" + name + "%")
                .setFirstResult((page-1) * size) //从第几个开始显示
                .setMaxResults(size) //显示几个
                .list();
    }

    @Override
    public Long getCount(String name) {
        String hql = "select count(p) from ProductEntity p where p.name like :name";
        return (Long) getSession().createQuery(hql)
                .setParameter("name", "%" + name + "%")
                .uniqueResult(); //返回一条记录:总记录数
    }

    @Override
    public List<ProductEntity> queryByCategoryId(int cid) {
        String hql = "from ProductEntity p join fetch p.categoryEntity "
                   + "where p.commend=1 and p.open=1 and p.categoryEntity.id=:cid order by p.date desc";
        return getSession().createQuery(hql)
                .setParameter("cid", cid)
                .setFirstResult(0)
                .setMaxResults(4)
                .list();
    }
}
