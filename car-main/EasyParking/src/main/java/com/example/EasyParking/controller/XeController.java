package com.example.EasyParking.controller;

import com.example.EasyParking.dto.XeRequest;
import com.example.EasyParking.entity.Xe;
import com.example.EasyParking.service.XeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/xe")
@RequiredArgsConstructor
public class XeController {

    private final XeService service;

    @PostMapping
    public Xe create(@RequestBody XeRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<Xe> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Xe getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Xe update(@PathVariable String id, @RequestBody XeRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}

