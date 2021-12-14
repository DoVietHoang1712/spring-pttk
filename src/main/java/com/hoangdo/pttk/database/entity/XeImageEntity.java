package com.hoangdo.pttk.database.entity;

import com.hoangdo.pttk.api.dto.XeImage;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "xe_image")
@Setter
public class XeImageEntity extends XeImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {return super.getId();}

    @Column(name = "url")
    @Override
    public String getUrl() {return super.getUrl();}

    @Column(name = "is_main")
    @Override
    public Boolean getIsMain() {return super.getIsMain();}

    @Override
    @ManyToOne
    @JoinColumn(name = "xe_id")
    public XeEntity getXe() {
        return (XeEntity) super.getXe();
    }
}
