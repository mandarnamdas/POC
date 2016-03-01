package com.nihilent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "rectangle")
@Entity
public class Rectangle extends Shape {

    private Long length;

    private Long breadth;

    @Column(name = "length")
    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    @Column(name = "breadth")
    public Long getBreadth() {
        return breadth;
    }

    public void setBreadth(Long breadth) {
        this.breadth = breadth;
    }
}
