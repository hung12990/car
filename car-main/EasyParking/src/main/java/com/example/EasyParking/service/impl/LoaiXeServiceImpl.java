package com.example.EasyParking.service.impl;

import com.example.EasyParking.dto.LoaiXeRequest;
import com.example.EasyParking.entity.LoaiXe;
import com.example.EasyParking.repository.LoaiXeRepository;
import com.example.EasyParking.service.LoaiXeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoaiXeServiceImpl implements LoaiXeService {

    private final LoaiXeRepository repository;

    @Override
    public LoaiXe create(LoaiXeRequest request) {

        if (repository.existsByTenLoaiAndDeleteFlag(request.getTenLoai(), 0)) {
            throw new RuntimeException("Loại xe đã tồn tại");
        }

        LoaiXe loaiXe = LoaiXe.builder()
                .maLoai(UUID.randomUUID().toString())
                .tenLoai(request.getTenLoai())
                .giaXe(request.getGiaXe())
                .createdBy("SYSTEM")
                .createdDate(LocalDateTime.now())
                .deleteFlag(0)
                .build();

        return repository.save(loaiXe);
    }

    @Override
    public LoaiXe update(String maLoai, LoaiXeRequest request) {
        LoaiXe loaiXe = getById(maLoai);

        loaiXe.setTenLoai(request.getTenLoai());
        loaiXe.setGiaXe(request.getGiaXe());
        loaiXe.setLastModifiedBy("SYSTEM");
        loaiXe.setLastModifiedDate(LocalDateTime.now());

        return repository.save(loaiXe);
    }

    @Override
    public LoaiXe getById(String maLoai) {
        return repository.findById(maLoai)
                .filter(lx -> lx.getDeleteFlag() == 0)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy loại xe"));
    }

    @Override
    public List<LoaiXe> getAll() {
        return repository.findByDeleteFlag(0);
    }

    @Override
    public void delete(String maLoai) {
        LoaiXe loaiXe = getById(maLoai);
        loaiXe.setDeleteFlag(1);
        loaiXe.setLastModifiedDate(LocalDateTime.now());
        repository.save(loaiXe);
    }
}

