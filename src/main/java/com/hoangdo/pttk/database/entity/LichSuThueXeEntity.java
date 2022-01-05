package com.hoangdo.pttk.database.entity;

import com.hoangdo.pttk.api.dto.LichSuThueXe;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lich_su_thue_xe")
@Setter
public class LichSuThueXeEntity extends LichSuThueXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {return super.getId();}

    @Override
    @Column(name = "ngay_tra_xe")
    public Date getNgayTraXe() {return super.getNgayTraXe();}

    @Override
    @Column(name = "ngay_thue_xe")
    public Date getNgayThueXe() {return super.getNgayThueXe();}

    @Override
    @Column(name = "thoi_gian")
    public Integer getThoiGian() {return super.getThoiGian();}

    @Override
    @Column(name = "id_xe")
    public Long getIdXe() {return super.getIdXe();}

    @Override
    @Column(name = "id_khach_hang")
    public Long getIdKhachHang() {return super.getIdKhachHang();}

    @Override
    @Column(name = "type")
    public String getType() {return super.getType();}

    @Override
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lich_su_giao_dich", referencedColumnName = "id")
    public LichSuGiaoDichEntity getLichSuGiaoDich() {return (LichSuGiaoDichEntity) super.getLichSuGiaoDich();}
}
