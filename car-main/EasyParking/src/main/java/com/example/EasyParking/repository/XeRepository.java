package com.example.EasyParking.repository;

import com.example.EasyParking.entity.Xe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface XeRepository extends JpaRepository<Xe, String> {
    boolean existsByBienSoAndDeleteFlag(String bienSo, Integer deleteFlag);
    List<Xe> findByDeleteFlag(Integer deleteFlag);
}

