package com.example.EasyParking.service.impl;

import com.example.EasyParking.dto.NhanVienRequest;
import com.example.EasyParking.entity.NhanVien;
import com.example.EasyParking.repository.NhanVienRepository;
import com.example.EasyParking.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository repository;

    @Override
    public NhanVien create(NhanVienRequest request) {

        if (repository.existsByTaiKhoanAndDeleteFlag(request.getTaiKhoan(), 0)) {
            throw new RuntimeException("Tài khoản đã tồn tại");
        }

        NhanVien nv = NhanVien.builder()
                .maNhanVien(UUID.randomUUID().toString())
                .hoTen(request.getHoTen())
                .taiKhoan(request.getTaiKhoan())
                .matKhau(request.getMatKhau()) // sau này nên mã hóa
                .chucVu(request.getChucVu())
                .createdBy("SYSTEM")
                .createdDate(LocalDateTime.now())
                .deleteFlag(0)
                .build();

        return repository.save(nv);
    }

    @Override
    public NhanVien update(String maNhanVien, NhanVienRequest request) {

        NhanVien nv = getById(maNhanVien);

        nv.setHoTen(request.getHoTen());
        nv.setChucVu(request.getChucVu());
        nv.setLastModifiedBy("SYSTEM");
        nv.setLastModifiedDate(LocalDateTime.now());

        return repository.save(nv);
    }

    @Override
    public NhanVien getById(String maNhanVien) {
        return repository.findById(maNhanVien)
                .filter(nv -> nv.getDeleteFlag() == 0)
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));
    }

    @Override
    public List<NhanVien> getAll() {
        return repository.findByDeleteFlag(0);
    }

    @Override
    public void delete(String maNhanVien) {
        NhanVien nv = getById(maNhanVien);
        nv.setDeleteFlag(1); // soft delete
        nv.setLastModifiedDate(LocalDateTime.now());
        repository.save(nv);
    }
}

