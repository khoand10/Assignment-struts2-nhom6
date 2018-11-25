package com.poly.dao;

import com.poly.entity.Class;

import java.util.List;

public interface ClassDAO {
    List<Class> listClass();

    void saveOrUpdateClass(Class c);

    Class listClassById(Long cId);

    void deleteClass(Long cId);
}
