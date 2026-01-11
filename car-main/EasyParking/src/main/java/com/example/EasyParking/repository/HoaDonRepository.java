package com.example.EasyParking.repository;

import com.example.EasyParking.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HoaDonRepository extends JpaRepository<HoaDon, String> {

    boolean existsByMaLichSu(String maLichSu);
    List<HoaDon> findAllByDeleteFlag(Integer deleteFlag);
    @Query("""
        SELECT hd, ls, nv, x, lx, kh
        FROM HoaDon hd
        JOIN LichSuSuDungThe ls ON hd.maLichSu = ls.maLichSu
        JOIN hd.nhanVien nv
        JOIN ls.xe x
        JOIN x.loaiXe lx
        JOIN x.khachHang kh
        WHERE hd.deleteFlag = 0
          AND ls.deleteFlag = 0
    """)
    List<Object[]> findAllHoaDonFull();
}

