package com.example.EasyParking.service.impl;
import com.example.EasyParking.dto.NhanVienRequest;
import com.example.EasyParking.entity.NhanVien;
import com.example.EasyParking.entity.TheGuiXe;
import com.example.EasyParking.repository.NhanVienRepository;
import com.example.EasyParking.repository.TheGuiXeRepository;
import com.example.EasyParking.service.NhanVienService;
import com.example.EasyParking.service.TheGuiXeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class TheGuiXeServiceImpl implements TheGuiXeService {

    private final TheGuiXeRepository repository;
    private final NhanVienRepository nhanVienRepository;

    @Override
    public TheGuiXe create(String maNhanVien) {

        NhanVien nv = nhanVienRepository.findById(maNhanVien)
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));

        TheGuiXe the = TheGuiXe.builder()
                .maThe(UUID.randomUUID().toString())
                .thoiGianCap(LocalDateTime.now())
                .nhanVien(nv)
                .createdBy("SYSTEM")
                .createdDate(LocalDateTime.now())
                .deleteFlag(0)
                .build();

        return repository.save(the);
    }

    @Override
    public List<TheGuiXe> getAll() {
        return repository.findByDeleteFlag(0);
    }

    @Override
    public void delete(String maThe) {
        TheGuiXe the = repository.findById(maThe)
                .orElseThrow(() -> new RuntimeException("Thẻ không tồn tại"));

        the.setDeleteFlag(1);
        repository.save(the);
    }
}

