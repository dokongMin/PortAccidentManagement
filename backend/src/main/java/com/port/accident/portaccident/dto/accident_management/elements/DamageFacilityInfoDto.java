package com.port.accident.portaccident.dto.accident_management.elements;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacility;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class DamageFacilityInfoDto {

    private String name;

    private AccidentInfo accidentInfo;

    private DamageFacility damageFacility;

    @Builder
    public DamageFacilityInfoDto(String name, AccidentInfo accidentInfo, DamageFacility damageFacility) {
        this.name = name;
        this.accidentInfo = accidentInfo;
        this.damageFacility = damageFacility;
    }


    public DamageFacilityInfo toEntity(){
        return DamageFacilityInfo.builder()
                .name(name)
                .accidentInfo(accidentInfo)
                .damageFacility(damageFacility)
                .build();
    }
}

