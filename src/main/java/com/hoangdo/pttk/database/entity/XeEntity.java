package com.hoangdo.pttk.database.entity;

import com.hoangdo.pttk.api.dto.Xe;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "xe")
@Setter
public class XeEntity extends Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId(){return super.getId();}

    @Override
    @Column(name = "loai_xe")
    public String getLoaiXe() {return super.getLoaiXe();};

    @Override
    @Column(name = "trang_thai")
    public String getTrangThai() {return super.getTrangThai();};

    @Override
    @Column(name = "mo_ta")
    public String getMoTa() {return super.getMoTa();};

    @Override
    @Column(name = "price_per_hour")
    public Double getPricePerHour() {return super.getPricePerHour();}

    @Override
    @Column(name = "price_per_day")
    public Double getPricePerDay() {return super.getPricePerDay();}

    @Override
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "xe")
    public List<XeImageEntity> getImages() {return (List<XeImageEntity>) super.getImages();}
}
