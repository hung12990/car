package com.example.EasyParking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "LOAIXE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoaiXe {

    @Id
    @Column(name = "MALOAI")
    private String maLoai;

    @Column(name = "TENLOAI", nullable = false, length = 50)
    private String tenLoai;

    @Column(name = "GIAXE", nullable = false, precision = 12, scale = 2)
    private BigDecimal giaXe;

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

