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
    @Column(name = "loaiXe")
    public String getLoaiXe() {return super.getLoaiXe();};

    @Override
    @Column(name = "trangThai")
    public String getTrangThai() {return super.getTrangThai();};

    @Override
    @Column(name = "moTa")
    public String getMoTa() {return super.getMoTa();};

    @Override
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "xe")
    public List<XeImageEntity> getImages() {return (List<XeImageEntity>) super.getImages();}
}
