package com.poly.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.poly.dao.AccountDAO;
import com.poly.dao.impl.AccountDAOImpl;
import com.poly.entity.Account;

import java.util.Map;

public class RegisterAction extends ActionSupport {

    private String name;
    private String email;
    private String password;
    private String confirmPassword;

    public String execute() {
        AccountDAO accountDAO = new AccountDAOImpl();

        if (accountDAO.findOne(email) != null) {
            addFieldError("email", "Email already exists");
            return INPUT;
        } else {
            accountDAO.create(new Account(name, password, email));
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("success", "You registered successfully!");
            return SUCCESS;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
