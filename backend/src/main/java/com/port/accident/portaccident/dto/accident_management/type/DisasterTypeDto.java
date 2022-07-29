package com.port.accident.portaccident.dto.accident_management.type;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.type.DisasterType;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class DisasterTypeDto {
    private Integer id;
    private String name;
    private AccidentInfo accidentInfo;

    @Builder
    public DisasterTypeDto(String name, AccidentInfo accidentInfo) {
        this.name = name;
        this.accidentInfo = accidentInfo;
    }

    public DisasterType toEntity() {
        return DisasterType.builder()
                .name(name)
                .accidentInfo(accidentInfo)
                .build();
    }
}
