package com.mycompany.dao;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.mycompany.common.Dao;
import com.mycompany.common.dao.GenericDAOImpl;
import com.mycompany.entity.Shape;

@Dao
public class ShapeOperationDAO extends GenericDAOImpl<Shape, Long> {

    Logger logger = LoggerFactory.getLogger(ShapeOperationDAO.class);
    Marker marker = MarkerFactory.getMarker("TRANSACTION");

    @PostConstruct
    public void init() {
        logger.info(marker, "Instantiate ShapeOperationDAO : " + this.hashCode());
    }
}
