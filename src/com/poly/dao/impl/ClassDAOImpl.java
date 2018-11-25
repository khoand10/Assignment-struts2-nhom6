package com.poly.dao.impl;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.poly.dao.ClassDAO;
import com.poly.entity.Class;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClassDAOImpl implements ClassDAO {

    @SessionTarget
    Session session;

    @TransactionTarget
    Transaction transaction;

    @Override
    @SuppressWarnings("unchecked")
    public List<Class> listClass() {
        List<Class> courses = null;
        try {
            courses = session.createQuery("from Class").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public void saveOrUpdateClass(Class c) {
        try {
            session.saveOrUpdate(c);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClass(Long cId) {
        try {
            Class c = (Class) session.get(Class.class, cId);
            session.delete(c);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Class listClassById(Long cId) {
        Class c = null;
        try {
            c = (Class) session.get(Class.class, cId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}
