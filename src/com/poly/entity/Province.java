package com.poly.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "province")
public class Province implements Serializable {
    private int id;

    private String name;

    public Province(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Province() {
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
