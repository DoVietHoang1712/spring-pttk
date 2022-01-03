package com.hoangdo.pttk.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentBikeDto {
    private String type;
    private Integer numsOfRent;
    private Long xeId;
    private Long promotionId;
    private Date rentDate;
}
