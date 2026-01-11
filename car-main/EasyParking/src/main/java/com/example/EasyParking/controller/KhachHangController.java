package com.example.EasyParking.controller;

import com.example.EasyParking.dto.KhachHangRequest;
import com.example.EasyParking.entity.KhachHang;
import com.example.EasyParking.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khach-hang")
@RequiredArgsConstructor
public class KhachHangController {

    private final KhachHangService service;

    @PostMapping
    public KhachHang create(@RequestBody KhachHangRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public KhachHang update(
            @PathVariable("id") String id,
            @RequestBody KhachHangRequest request
    ) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public KhachHang getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<KhachHang> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}

