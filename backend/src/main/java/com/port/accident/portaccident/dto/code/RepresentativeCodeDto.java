package com.port.accident.portaccident.dto.code;

import com.port.accident.portaccident.domain.code.RepresentativeCode;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class RepresentativeCodeDto {
    private String name;
    private String code;

    @Builder
    public RepresentativeCodeDto(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public RepresentativeCode toEntity() {
        return RepresentativeCode.builder()
                .name(name)
                .code(code)
                .build();
    }
}
