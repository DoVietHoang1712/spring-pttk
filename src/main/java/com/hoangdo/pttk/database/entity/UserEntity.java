package com.hoangdo.pttk.database.entity;

import com.hoangdo.pttk.api.dto.User;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "user")
@Entity
@Setter
public class UserEntity extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {return super.getId();}

    @Column(name = "ten")
    @Override
    public String getTen() {return super.getTen();}

    @Column(name = "ho_dem")
    @Override
    public String getHoDem() {return super.getHoDem();}

    @Column(name = "ngay_sinh")
    @Override
    public Date getNgaySinh() {return super.getNgaySinh();}

    @Column(name = "email")
    @Override
    public String getEmail() {return super.getEmail();}

    @Column(name = "so_dien_thoai")
    @Override
    public String getSoDienThoai() {return super.getSoDienThoai();}

    @Column(name = "ghi_chu")
    @Override
    public String getGhiChu() {return super.getGhiChu();}

    @Column(name = "username")
    @Override
    public String getUsername() {return super.getUsername();}

    @Column(name = "password")
    @Override
    public String getPassword() {return super.getPassword();}

    @Column(name = "loai_tai_khoan")
    @Override
    public String getLoaiTaiKhoan() {return super.getLoaiTaiKhoan();}

    @Column(name = "trang_thai_tai_khoan")
    @Override
    public String getTrangThaiTaiKhoan() {return super.getTrangThaiTaiKhoan();}

    @Column(name = "so_tai_khoan_nh")
    @Override
    public String getSoTaiKhoanNH() {return super.getSoTaiKhoanNH();}

    @Column(name = "ngan_hang")
    @Override
    public String getNganHang() {return super.getNganHang();}

    @Column(name = "so_du_tai_khoan")
    @Override
    public Double getSoDuTaiKhoan() {return super.getSoDuTaiKhoan();}

    @Column(name = "hang")
    @Override
    public String getHang() {return super.getHang();}

}
