package com.example.EasyParking.service;

import com.example.EasyParking.dto.LoaiXeRequest;
import com.example.EasyParking.entity.LoaiXe;

import java.util.List;

public interface LoaiXeService {

    LoaiXe create(LoaiXeRequest request);

    LoaiXe update(String maLoai, LoaiXeRequest request);

    LoaiXe getById(String maLoai);

    List<LoaiXe> getAll();

    void delete(String maLoai);
}

