package com.example.EasyParking.service.impl;

import com.example.EasyParking.dto.KhachHangRequest;
import com.example.EasyParking.entity.KhachHang;
import com.example.EasyParking.repository.KhachHangRepository;
import com.example.EasyParking.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository repository;

    @Override
    public KhachHang create(KhachHangRequest request) {
        KhachHang kh = KhachHang.builder()
                .maKhachHang(UUID.randomUUID().toString())
                .hoTen(request.getHoTen())
                .soDienThoai(request.getSoDienThoai())
                .gioiTinh(request.getGioiTinh())
                .diaChi(request.getDiaChi())
                .createdBy("SYSTEM")
                .createdDate(LocalDateTime.now())
                .deleteFlag(0)
                .build();

        return repository.save(kh);
    }

    @Override
    public KhachHang update(String maKhachHang, KhachHangRequest request) {
        KhachHang kh = getById(maKhachHang);

        kh.setHoTen(request.getHoTen());
        kh.setSoDienThoai(request.getSoDienThoai());
        kh.setGioiTinh(request.getGioiTinh());
        kh.setDiaChi(request.getDiaChi());
        kh.setLastModifiedBy("SYSTEM");
        kh.setLastModifiedDate(LocalDateTime.now());

        return repository.save(kh);
    }

    @Override
    public KhachHang getById(String maKhachHang) {
        return repository.findById(maKhachHang)
                .filter(kh -> kh.getDeleteFlag() == 0)
                .orElseThrow(() -> new RuntimeException("Khách hàng không tồn tại"));
    }

    @Override
    public List<KhachHang> getAll() {
        return repository.findByDeleteFlag(0);
    }

    @Override
    public void delete(String maKhachHang) {
        KhachHang kh = getById(maKhachHang);
        kh.setDeleteFlag(1); // soft delete
        kh.setLastModifiedDate(LocalDateTime.now());
        repository.save(kh);
    }
}

