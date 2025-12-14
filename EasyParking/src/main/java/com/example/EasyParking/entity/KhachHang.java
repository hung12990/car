package com.example.EasyParking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "KHACHHANG")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhachHang {

    @Id
    @Column(name = "MAKHACHHANG", length = 255)
    private String maKhachHang;

    @Column(name = "HOTEN", nullable = false, length = 100)
    private String hoTen;

    @Column(name = "SODIENTHOAI", nullable = false, length = 15)
    private String soDienThoai;

    @Column(name = "GIOITINH", length = 10)
    private String gioiTinh;

    @Column(name = "DIACHI", length = 150)
    private String diaChi;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDateTime lastModifiedDate;

    @Column(name = "DELETE_FLAG", nullable = false)
    private Integer deleteFlag;
}

