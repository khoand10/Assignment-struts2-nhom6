package com.poly.dao;

import com.poly.entity.Province;

import java.util.List;

public interface ProvinceDAO {
    List<Province> listProvince();

    void saveOrUpdateProvince(Province province);

    Province listProvinceById(Long provinceId);

    void deleteProvince(Long provinceId);
}
