package com.poly.dao;

import com.poly.entity.Department;

import java.util.List;

public interface DepartmentDAO {
    List<Department> listDepartment();

    void saveOrUpdateDepartment(Department d);

    Department listDepartmentById(Long dId);

    void deleteDepartment(Long dId);
}
