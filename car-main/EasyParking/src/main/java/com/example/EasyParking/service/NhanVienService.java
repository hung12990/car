package com.example.EasyParking.service;

import com.example.EasyParking.dto.NhanVienRequest;
import com.example.EasyParking.entity.NhanVien;

import java.util.List;

public interface NhanVienService {

    NhanVien create(NhanVienRequest request);

    NhanVien update(String maNhanVien, NhanVienRequest request);

    NhanVien getById(String maNhanVien);

    List<NhanVien> getAll();

    void delete(String maNhanVien);
}

