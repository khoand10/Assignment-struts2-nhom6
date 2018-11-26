package com.poly.dao.impl;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.poly.dao.DepartmentDAO;
import com.poly.entity.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    @SessionTarget
    Session session;

    @TransactionTarget
    Transaction transaction;

    @Override
    @SuppressWarnings("unchecked")
    public List<Department> listDepartment() {
        List<Department> courses = null;
        try {
            courses = session.createQuery("from Department").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public void saveOrUpdateDepartment(Department department) {
        try {
            session.saveOrUpdate(department);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        try {
            Department department = (Department) session.get(Department.class, departmentId);
            session.delete(department);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Department listDepartmentById(Long departmentId) {
        Department department = null;
        try {
            department = (Department) session.get(Department.class, departmentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }
}
