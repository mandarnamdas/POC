package com.nihilent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "circle")
@Entity
public class Circle extends Shape {

    private Long radius;

    @Column(name = "radius")
    public Long getRadius() {
        return radius;
    }

    public void setRadius(Long radius) {
        this.radius = radius;
    }
}
