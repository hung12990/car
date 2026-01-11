package com.example.EasyParking.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "HOADON")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoaDon {

    @Id
    @Column(name = "MALICHSU", length = 255)
    private String maLichSu;

    @ManyToOne
    @JoinColumn(name = "MANHANVIEN", nullable = false)
    private NhanVien nhanVien;

    @Column(name = "NGAYTHANHTOAN", nullable = false)
    private LocalDateTime ngayThanhToan;

    @Column(name = "THOIGIANGUI", nullable = false)
    private Long thoiGianGui; // phút

    @Column(name = "PHI", nullable = false)
    private BigDecimal phi;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "DELETE_FLAG", nullable = false)
    private Integer deleteFlag;
}
