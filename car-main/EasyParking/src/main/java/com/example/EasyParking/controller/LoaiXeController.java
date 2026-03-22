package com.example.EasyParking.controller;

import com.example.EasyParking.dto.LoaiXeRequest;
import com.example.EasyParking.entity.LoaiXe;
import com.example.EasyParking.service.LoaiXeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location/loai-xe")
@RequiredArgsConstructor
public class LoaiXeController {

    private final LoaiXeService service;

    @PostMapping
    public LoaiXe create(@RequestBody LoaiXeRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public LoaiXe update(
            @PathVariable("id") String id,
            @RequestBody LoaiXeRequest request
    ) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public LoaiXe getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<LoaiXe> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}

