package com.mycompany.common.dao;

import java.io.Serializable;
import java.util.List;

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
    E find(PK id);

    List<E> get();
}
