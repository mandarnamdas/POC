package com.mycompany.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.dao.CustomHibernateDaoSupport;

/**
 * @param <E>
 * @param <PK>
 */
public class GenericDAOImpl<E, PK extends Serializable> extends CustomHibernateDaoSupport
        implements GenericDAO<E, PK> {

    /**
     *
     */
    @Autowired
    protected SessionFactory sessionFactory;

    /**
     *
     */
    protected Class entityClass;

    /**
     *
     */
    public GenericDAOImpl() {
        this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public E save(E newInstance) {
        getHibernateTemplate().persist(newInstance);
        getHibernateTemplate().flush();
        getHibernateTemplate().refresh(newInstance);
        return newInstance;
    }

    public E update(E obj) {
        obj = getHibernateTemplate().merge(obj);
        getHibernateTemplate().flush();
        getHibernateTemplate().refresh(obj);
        return obj;
    }

    public void delete(E obj) {
        getHibernateTemplate().delete(obj);
        getHibernateTemplate().flush();
    }

    public E find(Serializable id) {
        return (E) getHibernateTemplate().get(entityClass, id);
    }

    public List<E> get() {
        return getHibernateTemplate().loadAll(entityClass);
    }
}
