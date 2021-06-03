package com.project.service.impl;

import com.project.service.BaseService;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 公共方法业务接口实现类
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
@Data
@SuppressWarnings("all")// 去除所有警告信息（适用于强迫症患者）
public class BaseServiceImpl<T> implements BaseService<T> {
    /** 存储当前操作的类型，即泛型T */
    private final Class<T> clazz;
    /** session工厂 */
    private SessionFactory sessionFactory;// Lombok会代替Spring设值注入（这里必须从beans.xml中set进来，不能用@Resource）
    public BaseServiceImpl() {
        // 当前调用构造方法的对象this：this
        // 当前this对象的父类信息：this.getClass().getSuperclass()
        // 当前this对象的父类信息（包括泛型信息）：this.getClass().getGenericSuperclass()
        clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];// 拿到泛型参数类型
    }

    /** 从线程池拿Session，没有则创建 */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(T t) {
        getSession().save(t);
    }

    @Override
    public void delete(int id) {
        System.out.println(clazz.getSimpleName());
        String hql = "delete "+clazz.getSimpleName()+" as c where c.id=:id";
        getSession().createQuery(hql).setParameter("id", id).executeUpdate();
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public T getById(int id) {
        return (T) getSession().get(clazz, id);
    }

    @Override
    public List<T> query() {
        String hql = "from "+clazz.getSimpleName();
        return getSession().createQuery(hql).list();
    }
}
