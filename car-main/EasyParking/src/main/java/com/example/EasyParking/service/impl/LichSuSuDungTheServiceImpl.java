package com.example.EasyParking.service.impl;
import com.example.EasyParking.dto.KhuVucRequest;
import com.example.EasyParking.dto.XeRaRequest;
import com.example.EasyParking.dto.XeVaoRequest;
import com.example.EasyParking.entity.KhuVuc;
import com.example.EasyParking.entity.LichSuSuDungThe;
import com.example.EasyParking.entity.TheGuiXe;
import com.example.EasyParking.entity.Xe;
import com.example.EasyParking.repository.KhuVucRepository;
import com.example.EasyParking.repository.LichSuSuDungTheRepository;
import com.example.EasyParking.repository.TheGuiXeRepository;
import com.example.EasyParking.repository.XeRepository;
import com.example.EasyParking.service.KhuVucService;
import com.example.EasyParking.service.LichSuSuDungTheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class LichSuSuDungTheServiceImpl implements LichSuSuDungTheService {

    private final LichSuSuDungTheRepository repository;
    private final XeRepository xeRepository;
    private final TheGuiXeRepository theRepository;
    private final KhuVucRepository khuVucRepository;

    @Override
    @Transactional
    public LichSuSuDungThe xeVao(XeVaoRequest request) {

        Xe xe = xeRepository.findById(request.getMaXe())
                .orElseThrow(() -> new RuntimeException("Xe không tồn tại"));

        TheGuiXe the = theRepository.findById(request.getMaThe())
                .orElseThrow(() -> new RuntimeException("Thẻ không tồn tại"));

        KhuVuc khuVuc = khuVucRepository.findById(request.getMaKhuVuc())
                .orElseThrow(() -> new RuntimeException("Khu vực không tồn tại"));

        // ❌ Thẻ đang được sử dụng
        repository.findByTheGuiXe_MaTheAndTrangThaiSuDung(
                request.getMaThe(),
                "DANG_GUI"
        ).ifPresent(ls -> {
            throw new RuntimeException("Thẻ đang được sử dụng");
        });

        LichSuSuDungThe ls = LichSuSuDungThe.builder()
                .maLichSu(UUID.randomUUID().toString())
                .xe(xe)
                .theGuiXe(the)
                .khuVuc(khuVuc)
                .thoiGianBatDau(LocalDateTime.now())
                .trangThaiSuDung("DANG_GUI")
                .createdBy("SYSTEM")
                .createdDate(LocalDateTime.now())
                .deleteFlag(0)
                .build();

        return repository.save(ls);
    }

    @Override
    @Transactional
    public LichSuSuDungThe xeRa(XeRaRequest request) {

        LichSuSuDungThe ls = repository.findById(request.getMaLichSu())
                .orElseThrow(() -> new RuntimeException("Lịch sử không tồn tại"));

        if ("DA_RA".equals(ls.getTrangThaiSuDung())) {
            throw new RuntimeException("Xe đã ra trước đó");
        }

        ls.setThoiGianKetThuc(LocalDateTime.now());
        ls.setTrangThaiSuDung("DA_RA");

        return repository.save(ls);
    }
}

