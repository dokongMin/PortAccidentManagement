package com.port.accident.portaccident.dto.accident_management.elements;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityEnum;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class DamageFacilityInfoDto {

    private String name;

    private AccidentInfo accidentInfo;

    private DamageFacilityEnum damageFacilityEnum;

    @Builder
    public DamageFacilityInfoDto(String name, AccidentInfo accidentInfo, DamageFacilityEnum damageFacilityEnum) {
        this.name = name;
        this.accidentInfo = accidentInfo;
        this.damageFacilityEnum = damageFacilityEnum;
    }


    public DamageFacilityInfo toEntity(){
        return DamageFacilityInfo.builder()
                .name(name)
                .accidentInfo(accidentInfo)
                .damageFacilityEnum(damageFacilityEnum)
                .build();
    }
}

