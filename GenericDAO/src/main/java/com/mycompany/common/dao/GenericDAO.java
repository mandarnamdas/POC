package com.mycompany.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @param <E>
 * @param <PK>
 */
public interface GenericDAO<E, PK extends Serializable> {

    /**
     * @param newInstance
     * @return
     */
    E save(E newInstance);

    /**
     * @param obj
     * @return
     */
    E update(E obj);

    /**
     * @param obj
     */
    void delete(E obj);

    /**
     * @param id
     * @return
     */
    E findById(PK id);

    Long findCount();

    /**
     * @return
     */
    List<E> findAll();

    /**
     * @return
     */
    public List<PK> findAllIds();

    /**
     * @param propertyName
     * @param value
     * @return
     */
    @SuppressWarnings("unchecked")
    List<E> findAllByProperty(String propertyName, Object value);

    /**
     * @param propertyName
     * @param propertyValue
     * @param limit
     * @return
     */
    public List<E> findAllByPropertyWithLimit(String propertyName,
                                              Object propertyValue,
                                              Integer limit,
                                              String sortOrder);

    /**
     * @param propertyName
     * @param value
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<E> findAllByProperties(Map<String, Object> propertyNameValueMap);

    /**
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    List<E> findByExample(E object);

    /**
     * @param object
     * @param firstResult
     * @param maxResults
     * @return
     */
    @SuppressWarnings("unchecked")
    List<E> findByExample(E object, int firstResult, int maxResults);

    /**
     * @param obj
     * @return
     */
    E merge(E obj);

    /**
     * @return
     */
    Class<E> getEntityClass();

    /**
     * @param ids
     * @return
     */
    @SuppressWarnings("unchecked")
    List<E> findAllByIdList(List<PK> ids);

    /**
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    List<E> findByProperties(E object);

    public void saveAll(List<E> objectList);

    public void updateAll(List<E> objectList);

    public void deleteAll(List<E> objectList);
}
