package com.nihilent.common.dao;

import static javax.persistence.PersistenceContextType.EXTENDED;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @param <E>
 * @param <PK>
 */
public class GenericDAOImpl<E, PK extends Serializable> implements GenericDAO<E, PK> {

    // @PersistenceUnit(name = "MyPU")
    // EntityManagerFactory entityManagerFactory;
    /**
     *
     */
    @PersistenceContext(name = "MyPU", type = EXTENDED)
    protected EntityManager em;

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
        em.persist(newInstance);
        em.flush();
        em.refresh(newInstance);
        return newInstance;
    }

    public E update(E obj) {
        obj = em.merge(obj);
        em.flush();
        em.refresh(obj);
        return obj;
    }

    public void delete(E obj) {
        em.remove(obj);
        em.flush();
    }

    public E findById(PK id) {
        return (E) em.find(entityClass, id);
    }

    public List<E> findAll() {
        Query query = em.createQuery(String.format(
                "SELECT obj from %s as obj", entityClass.getName()));
        return query.getResultList();
    }

    public Long findCount() {
        Query query = em.createQuery("SELECT count(o) from " + entityClass.getName() + " as o");
        return (Long) query.getResultList().get(0);
    }

    public List<PK> findAllIds() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of
        // generated methods, choose
        // Tools | Templates.
    }

    public List<E> findAllByProperty(String propertyName, Object propertyValue) {
        Query query = em.createQuery(String.format(
                "SELECT obj from %s as obj where obj.%s = :propertyValue", entityClass.getName(),
                propertyName));
        query.setParameter("propertyValue", propertyValue);

        return query.getResultList();
    }

    public List<E> findAllByPropertyWithLimit(String propertyName,
            Object propertyValue,
            Integer limit,
            String sortOrder) {
        if (sortOrder == null
                || !(sortOrder.equalsIgnoreCase("asc") || sortOrder.equalsIgnoreCase("desc"))) {
            sortOrder = "asc";
        }
        Query query = em.createQuery(String.format(
                "SELECT obj from %s as obj where obj.%s = :propertyValue order by obj.id "
                        + sortOrder, entityClass.getName(), propertyName));
        query.setParameter("propertyValue", propertyValue);
        if (limit != null) {
            query.setMaxResults(limit);
        }
        return query.getResultList();
    }

    public List<E> findAllByProperties(Map<String, Object> propertyNameValueMap) {
        StringBuffer queryString = new StringBuffer(String.format(
                "SELECT obj FROM %s as obj ", entityClass.getName()));
        if (propertyNameValueMap != null && !propertyNameValueMap.isEmpty()) {
            queryString.append(" WHERE 1=1 ");
            for (String propertyName : propertyNameValueMap.keySet()) {
                queryString.append(String.format(
                        " and obj.%s = :%s", propertyName, propertyName.replace(".", "")));
            }
        }

        Query query = em.createQuery(queryString.toString());
        if (propertyNameValueMap != null && !propertyNameValueMap.isEmpty()) {
            for (String propertyName : propertyNameValueMap.keySet()) {
                query.setParameter(
                        propertyName.replace(".", ""), propertyNameValueMap.get(propertyName));
            }
        }
        return query.getResultList();
    }

    public List<E> findByExample(E object) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of
        // generated methods, choose
        // Tools | Templates.
    }

    public List<E> findByExample(E object, int firstResult, int maxResults) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of
        // generated methods, choose
        // Tools | Templates.
    }

    public E merge(E obj) {
        E e = em.merge(obj);
        // em.flush();
        // em.refresh(obj);
        return e;

    }

    public Class<E> getEntityClass() {
        return this.entityClass;
    }

    public List<E> findAllByIdList(List<PK> ids) {
        Query query = em.createQuery("SELECT o from " + entityClass.getName()
                + " as o where o.id in (:ids)");
        query.setParameter("ids", ids);
        return query.getResultList();
    }

    public List<E> findByProperties(E object) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of
        // generated methods, choose
        // Tools | Templates.
    }

    public void saveAll(List<E> objectList) {
        int i = 0;
        for (final E obj : objectList) {
            em.persist(obj);
            i++;
            if (i > 0 && i % 100 == 0) {
                em.flush();
                em.refresh(obj);
            }
        }
        em.flush();
    }

    public void mergeAll(List<E> objectList) {
        int i = 0;
        for (final E obj : objectList) {
            em.merge(obj);
            i++;
            if (i > 0 && i % 100 == 0) {
                em.flush();
            }
        }
        em.flush();
    }

    public void updateAll(List<E> objectList) {
        int i = 0;
        for (final E obj : objectList) {
            em.merge(obj);
            i++;
            if (i > 0 && i % 100 == 0) {
                em.flush();
                em.refresh(obj);
            }
        }
        em.flush();
    }

    public void deleteAll(List<E> objectList) {
        int i = 0;
        for (final E obj : objectList) {
            em.remove(obj);
            i++;
            if (i > 0 && i % 100 == 0) {
                em.flush();
            }
        }
        em.flush();
    }

    public List<E> findAll(String propertyName, String sortOrder) {
        if (sortOrder == null
                || !(sortOrder.equalsIgnoreCase("asc") || sortOrder.equalsIgnoreCase("desc"))) {
            sortOrder = "asc";
        }
        Query query = em.createQuery(String.format(
                "SELECT obj from %s as obj order by obj.%s %s", entityClass.getName(),
                propertyName, sortOrder));
        return query.getResultList();
    }
}
