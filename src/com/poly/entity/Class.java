package com.poly.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "class")
public class Class implements Serializable {
    private int id;

    private String name;

    public Class(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Class() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
