package com.poly.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "department")
public class Department implements Serializable {
    private int id;

    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {
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
