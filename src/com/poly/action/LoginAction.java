package com.poly.action;

import java.util.Map;

import com.poly.dao.AccountDAO;
import com.poly.dao.impl.AccountDAOImpl;
import com.poly.entity.Account;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

    private String email;
    private String password;

    private SessionMap<String, Object> session;

    @Override
    public String execute() throws Exception {
        AccountDAO userDAO = new AccountDAOImpl();
        Account account = userDAO.login(email, password);

        if (account == null) {
            addActionError("Invalid email or password");
            return INPUT;
        } else {
            session.put("account", account);
            session.put("success", "You have logged in successfully!");
            return SUCCESS;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = (SessionMap<String, Object>) map;
    }
}