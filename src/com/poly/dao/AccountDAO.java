package com.poly.dao;

import com.poly.entity.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public interface AccountDAO{
    Account login(String email, String password);
}
