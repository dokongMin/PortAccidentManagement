package com.port.accident.portaccident.dto.accident_management.elements;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacility;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class DamageFacilityInfoDto {

    private Integer count;

    private AccidentInfo accidentInfo;

    private DamageFacility damageFacility;


    public DamageFacilityInfoDto(Integer count, AccidentInfo accidentInfo, DamageFacility damageFacility) {
        this.count = count;
        this.accidentInfo = accidentInfo;
        this.damageFacility = damageFacility;
    }

    @Builder
    public DamageFacilityInfo toEntity(){
        return DamageFacilityInfo.builder()
                .count(count)
                .accidentInfo(accidentInfo)
                .damageFacility(damageFacility)
                .build();
    }
}

