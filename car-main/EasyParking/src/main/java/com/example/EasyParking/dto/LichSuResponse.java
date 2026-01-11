package com.example.EasyParking.dto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class LichSuResponse {

    private String maLichSu;
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;
    private String trangThaiSuDung;

    private KhachHangResponse khachHang;
    private XeResponse xe;
}

