package com.example.EasyParking.service;

import com.example.EasyParking.dto.XeRequest;
import com.example.EasyParking.entity.Xe;

import java.util.List;

public interface XeService {
    Xe create(XeRequest request);
    Xe update(String maXe, XeRequest request);
    List<Xe> getAll();
    Xe getById(String maXe);
    void delete(String maXe);
}

