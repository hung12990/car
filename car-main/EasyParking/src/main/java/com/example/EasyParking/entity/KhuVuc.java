package com.example.EasyParking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "KHUVUC")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class KhuVuc {

    @Id
    @Column(name = "MAKHUVUC")
    private String maKhuVuc;

    @Column(name = "TENKHUVUC", nullable = false)
    private String tenKhuVuc;

    @Column(name = "SUCCHUA", nullable = false)
    private Integer sucChua;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "DELETE_FLAG")
    private Integer deleteFlag;
}

