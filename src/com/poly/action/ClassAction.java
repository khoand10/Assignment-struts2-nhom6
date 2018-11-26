package com.poly.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.poly.dao.ClassDAO;
import com.poly.dao.impl.ClassDAOImpl;
import com.poly.entity.Class;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class ClassAction extends ActionSupport implements ModelDriven<Class> {

    private Class c = new Class();
    private List<Class> cList = new ArrayList<Class>();
    private ClassDAO cDAO = new ClassDAOImpl();

    public Class getModel() {
        return c;
    }

    /**
     * To save or update c.
     * @return String
     */
    public String saveOrUpdate()
    {
        cDAO.saveOrUpdateClass(c);
        return SUCCESS;
    }

    /**
     * To list all cs.
     * @return String
     */
    public String list()
    {
        cList = cDAO.listClass();
        return SUCCESS;
    }

    /**
     * To delete a c.
     * @return String
     */
    public String delete()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        cDAO.deleteClass(Long.parseLong(request.getParameter("id")));
        return SUCCESS;
    }

    /**
     * To list a single c by Id.
     * @return String
     */
    public String edit()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        c = cDAO.listClassById(Long.parseLong(request.getParameter("id")));
        return SUCCESS;
    }

    public Class getC() {
        return c;
    }

    public void setC(Class c) {
        this.c = c;
    }

    public List<Class> getClassList() {
        return cList;
    }

    public void setClassList(List<Class> cList) {
        this.cList = cList;
    }

}

