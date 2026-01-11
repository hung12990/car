package com.example.EasyParking.service.impl;
import com.example.EasyParking.dto.*;
import com.example.EasyParking.entity.*;
import com.example.EasyParking.repository.HoaDonRepository;
import com.example.EasyParking.repository.KhachHangRepository;
import com.example.EasyParking.repository.LichSuSuDungTheRepository;
import com.example.EasyParking.repository.NhanVienRepository;
import com.example.EasyParking.service.HoaDonService;
import com.example.EasyParking.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HoaDonServiceImpl implements HoaDonService {

    private final HoaDonRepository hoaDonRepository;
    private final LichSuSuDungTheRepository lichSuRepository;
    private final NhanVienRepository nhanVienRepository;

    @Override
    @Transactional
    public HoaDon taoHoaDonSauKhiXeRa(String maLichSu, String maNhanVien) {

        // 1️⃣ Kiểm tra đã có hóa đơn chưa
        if (hoaDonRepository.existsByMaLichSu(maLichSu)) {
            throw new RuntimeException("Hóa đơn đã tồn tại");
        }

        // 2️⃣ Lấy lịch sử
        LichSuSuDungThe ls = lichSuRepository.findById(maLichSu)
                .orElseThrow(() -> new RuntimeException("Lịch sử không tồn tại"));

        if (!"DA_RA".equals(ls.getTrangThaiSuDung())) {
            throw new RuntimeException("Xe chưa ra, không thể tạo hóa đơn");
        }

        // 3️⃣ Tính thời gian gửi (phút)
        long thoiGianGui = Duration.between(
                ls.getThoiGianBatDau(),
                ls.getThoiGianKetThuc()
        ).toMinutes();

        // 4️⃣ Lấy giá xe
        BigDecimal giaXe = ls.getXe()
                .getLoaiXe()
                .getGiaXe();

        // 5️⃣ Tính phí (theo giờ, làm tròn lên)
        long soGio = (long) Math.ceil(thoiGianGui / 60.0);
        BigDecimal phi = giaXe.multiply(BigDecimal.valueOf(soGio));

        // 6️⃣ Lấy nhân viên
        NhanVien nv = nhanVienRepository.findById(maNhanVien)
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));

        // 7️⃣ Tạo hóa đơn
        HoaDon hd = HoaDon.builder()
                .maLichSu(maLichSu)
                .nhanVien(nv)
                .ngayThanhToan(LocalDateTime.now())
                .thoiGianGui(thoiGianGui)
                .phi(phi)
                .createdBy("SYSTEM")
                .createdDate(LocalDateTime.now())
                .deleteFlag(0)
                .build();

        return hoaDonRepository.save(hd);
    }

    @Override
    public List<HoaDonFullResponse> getAllHoaDon() {

        return hoaDonRepository.findAllHoaDonFull().stream().map(obj -> {

            HoaDon hd = (HoaDon) obj[0];
            LichSuSuDungThe ls = (LichSuSuDungThe) obj[1];
            NhanVien nv = (NhanVien) obj[2];
            Xe xe = (Xe) obj[3];
            LoaiXe lx = (LoaiXe) obj[4];
            KhachHang kh = (KhachHang) obj[5];

            return HoaDonFullResponse.builder()
                    .maLichSu(hd.getMaLichSu())
                    .ngayThanhToan(hd.getNgayThanhToan())
                    .thoiGianGui(hd.getThoiGianGui())
                    .phi(hd.getPhi())

                    .nhanVien(NhanVienResponse.builder()
                            .maNhanVien(nv.getMaNhanVien())
                            .hoTen(nv.getHoTen())
                            .build())

                    .lichSu(LichSuResponse.builder()
                            .maLichSu(ls.getMaLichSu())
                            .thoiGianBatDau(ls.getThoiGianBatDau())
                            .thoiGianKetThuc(ls.getThoiGianKetThuc())
                            .trangThaiSuDung(ls.getTrangThaiSuDung())

                            .khachHang(KhachHangResponse.builder()
                                    .maKhachHang(kh.getMaKhachHang())
                                    .hoTen(kh.getHoTen())
                                    .soDienThoai(kh.getSoDienThoai())
                                    .build())

                            .xe(XeResponse.builder()
                                    .bienSoXe(xe.getBienSo())
                                    .tenLoaiXe(lx.getTenLoai())
                                    .giaXe(lx.getGiaXe())
                                    .build())
                            .build())
                    .build();

        }).toList();
    }
}
