package com.hoangdo.pttk.database.entity;

import com.hoangdo.pttk.api.dto.LichSuGiaoDich;
import com.hoangdo.pttk.api.dto.LichSuThueXe;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lich_su_giao_dich")
@Setter
public class LichSuGiaoDichEntity extends LichSuGiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {return super.getId();}

    @Column(name = "id_khach_hang")
    @Override
    public Long getIdKhachHang() {return super.getIdKhachHang();}

    @Column(name = "hinh_thuc_thanh_toan")
    @Override
    public String getHinhThucThanhToan() {return super.getHinhThucThanhToan();}

    @Column(name = "ten_dich_vu")
    @Override
    public String getTenDichVu() {return super.getTenDichVu();}

    @Column(name = "so_tien")
    @Override
    public Double getSoTien() {return super.getSoTien();}

    @Column(name = "id_promotion")
    @Override
    public Long getIdPromotion() {return super.getIdPromotion();}

    @OneToOne(mappedBy = "lichSuGiaoDich")
    @Override
    public LichSuThueXeEntity getLichSuThueXe() {return (LichSuThueXeEntity) super.getLichSuThueXe();}
}
