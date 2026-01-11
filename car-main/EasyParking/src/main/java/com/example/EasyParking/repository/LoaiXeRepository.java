package com.example.EasyParking.repository;


import com.example.EasyParking.entity.LoaiXe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoaiXeRepository extends JpaRepository<LoaiXe, String> {

    List<LoaiXe> findByDeleteFlag(Integer deleteFlag);

    Optional<LoaiXe> findByTenLoaiAndDeleteFlag(String tenLoai, Integer deleteFlag);

    boolean existsByTenLoaiAndDeleteFlag(String tenLoai, Integer deleteFlag);
}

