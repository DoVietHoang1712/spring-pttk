package com.hoangdo.pttk.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {
    private Long id;
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;
    private Double discountPercent;
    private Long doiTuong;
    private Double discountMax;
}
