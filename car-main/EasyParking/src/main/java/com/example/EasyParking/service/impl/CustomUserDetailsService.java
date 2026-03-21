package com.example.EasyParking.service.impl;

import com.example.EasyParking.entity.NhanVien;
import com.example.EasyParking.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private NhanVienRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        NhanVien nv = repository.findByTaiKhoanAndDeleteFlag(username, 0)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new CustomUserDetails(nv);
    }
}