package com.example.EasyParking.repository;

import com.example.EasyParking.entity.LichSuSuDungThe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LichSuSuDungTheRepository
        extends JpaRepository<LichSuSuDungThe, String> {

    Optional<LichSuSuDungThe> findByTheGuiXe_MaTheAndTrangThaiSuDung(
            String maThe,
            String trangThaiSuDung
    );
}

