package com.example.EasyParking.repository;


import com.example.EasyParking.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhachHangRepository extends JpaRepository<KhachHang, String> {

    List<KhachHang> findByDeleteFlag(Integer deleteFlag);
}
