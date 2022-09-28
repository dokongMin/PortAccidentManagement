package com.port.accident.portaccident.dto.code;

import com.port.accident.portaccident.domain.code.RepresentativeCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DetailedCodeRegisterDto {

    private Integer id;
    private String name;
    private String code;
    private String comment;
    private String repCodeId;

    @Builder
    public DetailedCodeRegisterDto(Integer id, String name, String code, String comment, String repCodeId) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.comment = comment;
        this.repCodeId = repCodeId;
    }


}
