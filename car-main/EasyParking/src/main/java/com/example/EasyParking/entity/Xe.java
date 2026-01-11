package com.example.EasyParking.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "XE")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Xe {

    @Id
    @Column(name = "MAXE")
    private String maXe;

    @Column(name = "TENXE", nullable = false)
    private String tenXe;

    @Column(name = "BIENSO", nullable = false, unique = true)
    private String bienSo;

    @ManyToOne
    @JoinColumn(name = "MALOAI", nullable = false)
    private LoaiXe loaiXe;

    @ManyToOne
    @JoinColumn(name = "MAKHACHHANG", nullable = false)
    private KhachHang khachHang;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "DELETE_FLAG")
    private Integer deleteFlag;
}

