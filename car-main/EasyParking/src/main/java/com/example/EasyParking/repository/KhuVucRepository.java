package com.example.EasyParking.repository;

import com.example.EasyParking.entity.KhuVuc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhuVucRepository extends JpaRepository<KhuVuc, String> {
    List<KhuVuc> findByDeleteFlag(Integer deleteFlag);
}

