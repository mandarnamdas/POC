package com.nihilent.dao;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.nihilent.common.Dao;
import com.nihilent.common.dao.GenericDAOImpl;
import com.nihilent.entity.Shape;

@Dao
public class ShapeOperationDAO extends GenericDAOImpl<Shape, Long> {

    Logger logger = LoggerFactory.getLogger(ShapeOperationDAO.class);
    Marker marker = MarkerFactory.getMarker("TRANSACTION");

    @PostConstruct
    public void init() {
        logger.info(marker, "Instantiate ShapeOperationDAO : " + this.hashCode());
    }
}
