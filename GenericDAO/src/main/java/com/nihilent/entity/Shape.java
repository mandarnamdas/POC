package com.nihilent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.nihilent.common.entity.AbstractEntity;

@Table(name = "shape")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Shape extends AbstractEntity {

    private String shapeType;

    @Column(name = "shape_type")
    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }
}
