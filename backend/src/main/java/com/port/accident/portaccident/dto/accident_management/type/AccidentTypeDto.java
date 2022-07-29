package com.port.accident.portaccident.dto.accident_management.type;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class AccidentTypeDto {
    private Integer id;
    private String name;
    private AccidentInfo accidentInfo;

    @Builder
    public AccidentTypeDto(String name, AccidentInfo accidentInfo) {
        this.name = name;
        this.accidentInfo = accidentInfo;
    }

    public AccidentType toEntity() {
        return AccidentType.builder()
                .name(name)
                .accidentInfo(accidentInfo)
                .build();
    }
}
