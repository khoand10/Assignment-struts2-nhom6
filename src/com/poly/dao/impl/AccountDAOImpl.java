package com.poly.dao.impl;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.poly.dao.AccountDAO;
import com.poly.entity.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccountDAOImpl implements AccountDAO {
    @SessionTarget
    Session session;

    @TransactionTarget
    Transaction transaction;

    @Override
    public Account login(String email, String password) {
        Query query = session.createQuery("from Account where email=:email and password=:password");
        query.setString("email", email);
        query.setString("password", password);
        Account user = (Account) query.uniqueResult();
        if (user != null) {
            System.out.println("Account Retrieved from DB::" + user);
        }
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void create(Account account) {
        session.beginTransaction();
        session.persist(account);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Account findOne(String email) {
        session.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String hql = "from Account a " +
                "where a.email = :email";

        Account account;
        try {
            account = (Account) session.createQuery(hql).setParameter("email", email);
        } catch (Exception e) {
            account = null;
        }

        session.getTransaction().commit();
        session.close();
        return account;
    }


}
