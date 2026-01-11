package com.example.EasyParking.service;

import com.example.EasyParking.entity.TheGuiXe;

import java.util.List;

public interface TheGuiXeService {

    TheGuiXe create(String maNhanVien);

    List<TheGuiXe> getAll();

    void delete(String maThe);
}

