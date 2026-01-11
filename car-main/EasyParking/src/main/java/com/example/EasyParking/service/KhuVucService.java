package com.example.EasyParking.service;

import com.example.EasyParking.dto.KhuVucRequest;
import com.example.EasyParking.entity.KhuVuc;

import java.util.List;

public interface KhuVucService {
    KhuVuc create(KhuVucRequest request);
    KhuVuc update(String maKhuVuc, KhuVucRequest request);
    List<KhuVuc> getAll();
    void delete(String maKhuVuc);
}
