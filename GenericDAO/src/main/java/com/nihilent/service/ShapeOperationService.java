package com.nihilent.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nihilent.common.Dao;
import com.nihilent.common.InjectString;
import com.nihilent.dao.ShapeOperationDAO;
import com.nihilent.entity.Circle;
import com.nihilent.entity.Rectangle;
import com.nihilent.entity.Shape;

@Stateless
public class ShapeOperationService {

    Logger logger = LoggerFactory.getLogger(ShapeOperationService.class);

    @PostConstruct
    public void init() {
        logger.info("TestClass instantiated....");
    }

    @Inject
    @Dao
    ShapeOperationDAO shapeOperationDAO;

    @Inject
    @InjectString(key = "1")
    String injectString;

    public void createShape() {

        logger.info("The value of injected string : {}", injectString);

        Circle circle = new Circle();
        circle.setModifiedBy("Mandar_Circle");
        circle.setRadius(10l);
        circle.setShapeType("CIRCLE");
        Long shapeId = shapeOperationDAO.save(circle).getId();

        Rectangle rect = new Rectangle();
        rect.setModifiedBy("Mandar_Rect");
        rect.setLength(5l);
        rect.setBreadth(10l);
        rect.setShapeType("RECT");
        shapeOperationDAO.save(rect);

        Shape shape = shapeOperationDAO.findById(shapeId);
        shape.setShapeType("CIRCLE_UPDATED");
        shapeOperationDAO.save(shape);
    }

}
