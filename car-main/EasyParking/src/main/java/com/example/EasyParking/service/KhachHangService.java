package com.example.EasyParking.service;

import com.example.EasyParking.dto.KhachHangRequest;
import com.example.EasyParking.entity.KhachHang;

import java.util.List;

public interface KhachHangService {

    KhachHang create(KhachHangRequest request);

    KhachHang update(String maKhachHang, KhachHangRequest request);

    KhachHang getById(String maKhachHang);

    List<KhachHang> getAll();

    void delete(String maKhachHang);
}
