package com.hoangdo.pttk.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Xe {
    private Long id;
    private String loaiXe;
    private String trangThai;
    private String moTa;
    private Long idCuaHang;
    private List<? extends XeImage> images = new ArrayList<>();
}
