package com.poly.action;

import com.poly.dao.AccountDAO;
import com.poly.dao.AccountDAOImpl;
import com.poly.entity.Account;
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<Account> {
    private AccountDAO accountDAO = new AccountDAOImpl();
    private Account account = new Account();

    public String login() {
        Account accountDB = accountDAO.login(account.getEmail(), account.getPassword());
        if (accountDB == null) {
            return ERROR;
        }
        account.setEmail(accountDB.getEmail());
         account.setName(accountDB.getName());
        return SUCCESS;
    }

    public Account getModel() {
        return account;
    }

}