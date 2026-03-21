package com.example.EasyParking.service.impl;

import com.example.EasyParking.entity.NhanVien;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final NhanVien nhanVien;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + nhanVien.getChucVu()));
    }

    @Override
    public String getPassword() {
        return nhanVien.getMatKhau();
    }

    @Override
    public String getUsername() {
        return nhanVien.getTaiKhoan();
    }

    public String getMaNhanVien() {
        return nhanVien.getMaNhanVien();
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
