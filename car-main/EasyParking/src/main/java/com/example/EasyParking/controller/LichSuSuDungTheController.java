package com.example.EasyParking.controller;
import com.example.EasyParking.dto.KhachHangRequest;
import com.example.EasyParking.dto.KhuVucRequest;
import com.example.EasyParking.dto.XeRaRequest;
import com.example.EasyParking.dto.XeVaoRequest;
import com.example.EasyParking.entity.KhachHang;
import com.example.EasyParking.entity.KhuVuc;
import com.example.EasyParking.entity.LichSuSuDungThe;
import com.example.EasyParking.service.KhachHangService;
import com.example.EasyParking.service.KhuVucService;
import com.example.EasyParking.service.LichSuSuDungTheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location/lich-su")
@RequiredArgsConstructor
public class LichSuSuDungTheController {

    private final LichSuSuDungTheService service;

    //  XE VÀO
    @PostMapping("/xe-vao")
    public LichSuSuDungThe xeVao(@RequestBody XeVaoRequest request) {
        return service.xeVao(request);
    }

    //  XE RA
    @PostMapping("/xe-ra")
    public LichSuSuDungThe xeRa(@RequestBody XeRaRequest request) {
        return service.xeRa(request);
    }
}

