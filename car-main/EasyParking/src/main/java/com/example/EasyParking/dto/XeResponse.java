package com.example.EasyParking.dto;

import java.math.BigDecimal;
import lombok.*;
@Getter
@Setter
@Builder
public class XeResponse {

    private String bienSoXe;
    private String tenLoaiXe;
    private BigDecimal giaXe;
}

