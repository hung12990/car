package com.example.EasyParking.controller;
import com.example.EasyParking.dto.KhachHangRequest;
import com.example.EasyParking.dto.KhuVucRequest;
import com.example.EasyParking.entity.KhachHang;
import com.example.EasyParking.entity.KhuVuc;
import com.example.EasyParking.service.KhachHangService;
import com.example.EasyParking.service.KhuVucService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location/khu-vuc")
@RequiredArgsConstructor
public class KhuVucController {

    private final KhuVucService service;

    @PostMapping
    public KhuVuc create(@RequestBody KhuVucRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<KhuVuc> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public KhuVuc update(@PathVariable String id, @RequestBody KhuVucRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}

