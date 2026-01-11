package com.example.EasyParking.controller;

import com.example.EasyParking.dto.NhanVienRequest;
import com.example.EasyParking.entity.NhanVien;
import com.example.EasyParking.entity.TheGuiXe;
import com.example.EasyParking.service.NhanVienService;
import com.example.EasyParking.service.TheGuiXeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/the-gui-xe")
@RequiredArgsConstructor
public class TheGuiXeController {

    private final TheGuiXeService service;

    @PostMapping
    public TheGuiXe create(@RequestParam String maNhanVien) {
        return service.create(maNhanVien);
    }

    @GetMapping
    public List<TheGuiXe> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}

