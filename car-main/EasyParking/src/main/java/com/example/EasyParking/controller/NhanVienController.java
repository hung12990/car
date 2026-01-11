package com.example.EasyParking.controller;

import com.example.EasyParking.dto.NhanVienRequest;
import com.example.EasyParking.entity.NhanVien;
import com.example.EasyParking.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhan-vien")
@RequiredArgsConstructor
public class NhanVienController {

    private final NhanVienService service;

    @PostMapping
    public NhanVien create(@RequestBody NhanVienRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public NhanVien update(
            @PathVariable("id") String id,
            @RequestBody NhanVienRequest request
    ) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public NhanVien getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<NhanVien> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
