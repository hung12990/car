package com.example.EasyParking.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoaiXeRequest {
    private String tenLoai;
    private BigDecimal giaXe;
}

