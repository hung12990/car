package com.example.EasyParking.service;

import com.example.EasyParking.dto.XeRaRequest;
import com.example.EasyParking.dto.XeVaoRequest;
import com.example.EasyParking.entity.LichSuSuDungThe;

public interface LichSuSuDungTheService {

    LichSuSuDungThe xeVao(XeVaoRequest request);

    LichSuSuDungThe xeRa(XeRaRequest request);
}
