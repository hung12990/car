package com.example.EasyParking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "LICHSUSUDUNGTHE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LichSuSuDungThe {

    @Id
    @Column(name = "MALICHSU")
    private String maLichSu;

    @ManyToOne
    @JoinColumn(name = "MAXE", nullable = false)
    private Xe xe;

    @ManyToOne
    @JoinColumn(name = "MATHE", nullable = false)
    private TheGuiXe theGuiXe;

    @Column(name = "THOIGIANBATDAU", nullable = false)
    private LocalDateTime thoiGianBatDau;

    @Column(name = "THOIGIANKETTHUC")
    private LocalDateTime thoiGianKetThuc;

    @ManyToOne
    @JoinColumn(name = "MAKHUVUC", nullable = false)
    private KhuVuc khuVuc;

    @Column(name = "TRANGTHAISUDUNG", nullable = false)
    private String trangThaiSuDung; // DANG_GUI / DA_RA

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "DELETE_FLAG", nullable = false)
    private Integer deleteFlag;
}
