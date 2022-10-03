package com.port.accident.portaccident.dto.code;

import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class DetRepJoinDto {
    private Integer detId;
    private String detName;
    private String detCode;
    private String comment;
    private String repCode;

    @QueryProjection
    public DetRepJoinDto(Integer detId, String detName, String detCode, String comment, String repCode) {
        this.detId = detId;
        this.detName = detName;
        this.detCode = detCode;
        this.comment = comment;
        this.repCode = repCode;
    }
}
