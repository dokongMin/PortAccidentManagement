package com.port.accident.portaccident.dto.accident_management.elements;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacility;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class DamageFacilityDto {
    private String name;
    private AccidentInfo accidentInfo;

    @Builder
    public DamageFacilityDto(String name, AccidentInfo accidentInfo) {
        this.name = name;
        this.accidentInfo = accidentInfo;
    }

    public DamageFacility toEntity() {
        return DamageFacility.builder()
                .name(name)
                .accidentInfo(accidentInfo)
                .build();
    }
}
