package com.port.accident.portaccident.dto.accident_management.elements;


import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccident;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class CausesSafetyAccidentDto {
    private String name;
    private AccidentInfo accidentInfo;

    @Builder
    public CausesSafetyAccidentDto(String name, AccidentInfo accidentInfo) {
        this.name = name;
        this.accidentInfo = accidentInfo;
    }

    public CausesSafetyAccident toEntity() {
        return CausesSafetyAccident.builder()
                .name(name)
                .accidentInfo(accidentInfo)
                .build();
    }
}
