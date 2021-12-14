package com.hoangdo.pttk.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LichSuGiaoDich {
    private Long id;
    private Long idKhachHang;
    private String hinhThucThanhToan;
    private String tenDichVu;
    private Double soTien;
    private Long idPromotion;
    private LichSuThueXe lichSuThueXe;
}
