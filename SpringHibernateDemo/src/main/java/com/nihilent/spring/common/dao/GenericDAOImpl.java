package com.nihilent.spring.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @param <E>
 * @param <PK>
 */
public class GenericDAOImpl<E, PK extends Serializable> implements GenericDAO<E, PK> {

    /**
     *
     */
    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

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
        getSession().persist(newInstance);
        getSession().flush();
        getSession().refresh(newInstance);
        return newInstance;
    }

    public E update(E obj) {
        obj = (E) getSession().merge(obj);
        getSession().flush();
        getSession().refresh(obj);
        return obj;
    }

    public void delete(E obj) {
        getSession().delete(obj);
        getSession().flush();
    }

    public E find(Serializable id) {
        return (E) getSession().get(entityClass, id);
    }
}
