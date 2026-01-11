package com.example.EasyParking.service.impl;

import com.example.EasyParking.repository.KhachHangRepository;
import com.example.EasyParking.repository.LoaiXeRepository;
import com.example.EasyParking.repository.XeRepository;
import com.example.EasyParking.service.XeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.EasyParking.dto.XeRequest;
import com.example.EasyParking.entity.Xe;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class XeServiceImpl implements XeService {

    private final XeRepository xeRepo;
    private final LoaiXeRepository loaiXeRepo;
    private final KhachHangRepository khRepo;

    @Override
    public Xe create(XeRequest req) {

        if (xeRepo.existsByBienSoAndDeleteFlag(req.getBienSo(), 0)) {
            throw new RuntimeException("Biển số đã tồn tại");
        }

        Xe xe = Xe.builder()
                .maXe(UUID.randomUUID().toString())
                .tenXe(req.getTenXe())
                .bienSo(req.getBienSo())
                .loaiXe(loaiXeRepo.findById(req.getMaLoai()).orElseThrow())
                .khachHang(khRepo.findById(req.getMaKhachHang()).orElseThrow())
                .createdBy("SYSTEM")
                .createdDate(LocalDateTime.now())
                .deleteFlag(0)
                .build();

        return xeRepo.save(xe);
    }

    @Override
    public Xe update(String maXe, XeRequest req) {
        Xe xe = getById(maXe);
        xe.setTenXe(req.getTenXe());
        return xeRepo.save(xe);
    }

    @Override
    public List<Xe> getAll() {
        return xeRepo.findByDeleteFlag(0);
    }

    @Override
    public Xe getById(String maXe) {
        return xeRepo.findById(maXe)
                .filter(x -> x.getDeleteFlag() == 0)
                .orElseThrow(() -> new RuntimeException("Xe không tồn tại"));
    }

    @Override
    public void delete(String maXe) {
        Xe xe = getById(maXe);
        xe.setDeleteFlag(1);
        xeRepo.save(xe);
    }
}

