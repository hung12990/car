package com.example.EasyParking.dto;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class HoaDonFullResponse {

    private String maLichSu;
    private LocalDateTime ngayThanhToan;
    private Long thoiGianGui;
    private BigDecimal phi;

    private NhanVienResponse nhanVien;
    private LichSuResponse lichSu;
}
