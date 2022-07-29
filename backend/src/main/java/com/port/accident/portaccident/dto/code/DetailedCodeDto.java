package com.port.accident.portaccident.dto.code;

import com.port.accident.portaccident.domain.code.DetailedCode;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class DetailedCodeDto {
    private String name;
    private String code;
    private String comment;
    private RepresentativeCode representativeCode;

    @Builder
    public DetailedCodeDto(String name,String code, String comment, RepresentativeCode representativeCode) {
        this.name = name;
        this.code = code;
        this.comment = comment;
        this.representativeCode = representativeCode;
    }

    public DetailedCode toEntity() {
        return DetailedCode.builder()
                .name(name)
                .code(code)
                .comment(comment)
                .representativeCode(representativeCode)
                .build();
    }
}
