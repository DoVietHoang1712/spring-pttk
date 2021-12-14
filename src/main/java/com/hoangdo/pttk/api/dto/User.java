package com.hoangdo.pttk.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String ten;
    private String hoDem;
    private Date ngaySinh;
    private String email;
    private String soDienThoai;
    private String ghiChu;
    private String username;
    private String password;
    private String loaiTaiKhoan;
    private String trangThaiTaiKhoan;
    private Long idDiaChi;
    private String soTaiKhoanNH;
    private String nganHang;
    private Double soDuTaiKhoan;
    private String hang;
    private Long doiTuong;
}
