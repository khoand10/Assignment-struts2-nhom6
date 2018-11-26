package com.poly.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ModelDriven;
import com.poly.dao.DepartmentDAO;
import com.poly.dao.impl.DepartmentDAOImpl;
import com.poly.entity.Department;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

    private static final long serialVersionUID = -6659925652584240539L;

    private Department department = new Department();
    private List<Department> departmentList = new ArrayList<Department>();
    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();

    public Department getModel() {
        return department;
    }

    /**
     * To save or update department.
     * @return String
     */
    public String saveOrUpdate()
    {
        departmentDAO.saveOrUpdateDepartment(department);
        return SUCCESS;
    }

    /**
     * To list all departments.
     * @return String
     */
    public String list()
    {
        departmentList = departmentDAO.listDepartment();
        return SUCCESS;
    }

    /**
     * To delete a department.
     * @return String
     */
    public String delete()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        departmentDAO.deleteDepartment(Long.parseLong(request.getParameter("id")));
        return SUCCESS;
    }

    /**
     * To list a single department by Id.
     * @return String
     */
    public String edit()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        department = departmentDAO.listDepartmentById(Long.parseLong(request.getParameter("id")));
        return SUCCESS;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

}


