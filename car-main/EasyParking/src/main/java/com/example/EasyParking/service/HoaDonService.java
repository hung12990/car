package com.example.EasyParking.service;

import com.example.EasyParking.dto.HoaDonFullResponse;
import com.example.EasyParking.entity.HoaDon;

import java.util.List;

public interface HoaDonService {

    HoaDon taoHoaDonSauKhiXeRa(String maLichSu, String maNhanVien);
    List<HoaDonFullResponse> getAllHoaDon();
}

