package com.example.EasyParking.service.impl;

import com.example.EasyParking.dto.KhuVucRequest;
import com.example.EasyParking.entity.KhuVuc;
import com.example.EasyParking.repository.KhuVucRepository;
import com.example.EasyParking.service.KhuVucService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class KhuVucServiceImpl implements KhuVucService {

    private final KhuVucRepository repo;

    @Override
    public KhuVuc create(KhuVucRequest req) {
        KhuVuc kv = KhuVuc.builder()
                .maKhuVuc(UUID.randomUUID().toString())
                .tenKhuVuc(req.getTenKhuVuc())
                .sucChua(req.getSucChua())
                .createdBy("SYSTEM")
                .createdDate(LocalDateTime.now())
                .deleteFlag(0)
                .build();
        return repo.save(kv);
    }

    @Override
    public KhuVuc update(String id, KhuVucRequest req) {
        KhuVuc kv = repo.findById(id).orElseThrow();
        kv.setTenKhuVuc(req.getTenKhuVuc());
        kv.setSucChua(req.getSucChua());
        return repo.save(kv);
    }

    @Override
    public List<KhuVuc> getAll() {
        return repo.findByDeleteFlag(0);
    }

    @Override
    public void delete(String id) {
        KhuVuc kv = repo.findById(id).orElseThrow();
        kv.setDeleteFlag(1);
        repo.save(kv);
    }
}

