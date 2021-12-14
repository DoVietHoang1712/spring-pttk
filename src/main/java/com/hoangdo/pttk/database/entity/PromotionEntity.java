package com.hoangdo.pttk.database.entity;

import com.hoangdo.pttk.api.dto.Promotion;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "promotion")
@Setter
public class PromotionEntity extends Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {return super.getId();}

    @Override
    @Column(name = "thoi_gian_bat_dau")
    public Date getThoiGianBatDau() {return super.getThoiGianBatDau();}

    @Override
    @Column(name = "thoi_gian_ket_thuc")
    public Date getThoiGianKetThuc() {return super.getThoiGianKetThuc();}

    @Override
    @Column(name = "discount_percent")
    public Double getDiscountPercent() {return super.getDiscountPercent();}

    @Override
    @Column(name = "doi_tuong")
    public Long getDoiTuong() {return super.getDoiTuong();}

    @Override
    @Column(name = "discount_max")
    public Double getDiscountMax() {return super.getDiscountMax();}
}
