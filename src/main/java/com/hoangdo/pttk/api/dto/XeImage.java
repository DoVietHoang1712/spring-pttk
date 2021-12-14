package com.hoangdo.pttk.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XeImage {
    private Long id;
    private String url;
    private Boolean isMain;
    private Xe xe;
}
