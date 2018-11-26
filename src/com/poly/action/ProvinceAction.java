package com.poly.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ModelDriven;
import com.poly.dao.ProvinceDAO;
import com.poly.dao.impl.ProvinceDAOImpl;
import com.poly.entity.Province;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProvinceAction extends ActionSupport implements ModelDriven<Province> {

    private static final long serialVersionUID = -6659925652584240539L;

    private Province province = new Province();
    private List<Province> provinceList = new ArrayList<Province>();
    private ProvinceDAO provinceDAO = new ProvinceDAOImpl();

    public Province getModel() {
        return province;
    }

    /**
     * To save or update province.
     * @return String
     */
    public String saveOrUpdate()
    {
        provinceDAO.saveOrUpdateProvince(province);
        return SUCCESS;
    }

    /**
     * To list all provinces.
     * @return String
     */
    public String list()
    {
        provinceList = provinceDAO.listProvince();
        return SUCCESS;
    }

    /**
     * To delete a province.
     * @return String
     */
    public String delete()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        provinceDAO.deleteProvince(Long.parseLong(request.getParameter("id")));
        return SUCCESS;
    }

    /**
     * To list a single province by Id.
     * @return String
     */
    public String edit()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        province = provinceDAO.listProvinceById(Long.parseLong(request.getParameter("id")));
        return SUCCESS;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

}

