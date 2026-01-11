package com.example.EasyParking.controller;
import com.example.EasyParking.dto.HoaDonFullResponse;
import com.example.EasyParking.dto.KhachHangRequest;
import com.example.EasyParking.entity.HoaDon;
import com.example.EasyParking.entity.KhachHang;
import com.example.EasyParking.service.HoaDonService;
import com.example.EasyParking.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoa-don")
@RequiredArgsConstructor
public class HoaDonController {

    private final HoaDonService service;

    @PostMapping("/tao-sau-khi-xe-ra")
    public HoaDon taoHoaDon(
            @RequestParam String maLichSu,
            @RequestParam String maNhanVien
    ) {
        return service.taoHoaDonSauKhiXeRa(maLichSu, maNhanVien);
    }

    @GetMapping
    public List<HoaDonFullResponse> getAllHoaDon() {
        return service.getAllHoaDon();
    }
}

