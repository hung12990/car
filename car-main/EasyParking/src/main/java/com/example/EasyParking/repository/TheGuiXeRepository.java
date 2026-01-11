package com.example.EasyParking.repository;

import com.example.EasyParking.entity.NhanVien;
import com.example.EasyParking.entity.TheGuiXe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TheGuiXeRepository extends JpaRepository<TheGuiXe, String> {

    List<TheGuiXe> findByDeleteFlag(Integer deleteFlag);
}

