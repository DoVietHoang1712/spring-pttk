package com.hoangdo.pttk.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LichSuThueXe {
    private Long id;
    private Date ngayThueXe;
    private Date ngayTraXe;
    private Integer thoiGian;
    private LichSuGiaoDich lichSuGiaoDich;
    private Long idXe;
    private Long idKhachHang;
}
