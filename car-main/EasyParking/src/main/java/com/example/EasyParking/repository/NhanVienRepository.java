package com.example.EasyParking.repository;

import com.example.EasyParking.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

    List<NhanVien> findByDeleteFlag(Integer deleteFlag);

    Optional<NhanVien> findByTaiKhoanAndDeleteFlag(String taiKhoan, Integer deleteFlag);

    boolean existsByTaiKhoanAndDeleteFlag(String taiKhoan, Integer deleteFlag);
}

