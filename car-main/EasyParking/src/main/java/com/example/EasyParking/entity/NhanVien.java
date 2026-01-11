package com.example.EasyParking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "NHANVIEN")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NhanVien {

    @Id
    @Column(name = "MANHANVIEN", length = 255)
    private String maNhanVien;

    @Column(name = "HOTEN", nullable = false, length = 100)
    private String hoTen;

    @Column(name = "TAIKHOAN", nullable = false, unique = true, length = 50)
    private String taiKhoan;

    @Column(name = "MATKHAU", nullable = false, length = 100)
    private String matKhau;

    @Column(name = "CHUCVU", nullable = false, length = 50)
    private String chucVu;

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

