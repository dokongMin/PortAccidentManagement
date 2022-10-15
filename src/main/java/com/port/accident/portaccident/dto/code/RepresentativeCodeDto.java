package com.port.accident.portaccident.dto.code;

import com.port.accident.portaccident.domain.code.RepresentativeCode;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class RepresentativeCodeDto {
    private Integer id;
    private String name;
    private String code;

    @Builder
    public RepresentativeCodeDto(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public RepresentativeCode toEntity() {
        return RepresentativeCode.builder()
                .id(id)
                .name(name)
                .code(code)
                .build();
    }
}
