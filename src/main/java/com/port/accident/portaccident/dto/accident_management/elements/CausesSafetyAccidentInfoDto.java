package com.port.accident.portaccident.dto.accident_management.elements;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentEnum;
import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentInfo;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CausesSafetyAccidentInfoDto {

    private String name;

    private AccidentInfo accidentInfo;

    private CausesSafetyAccidentEnum causesSafetyAccidentEnum;

    @Builder
    public CausesSafetyAccidentInfoDto(String name, AccidentInfo accidentInfo, CausesSafetyAccidentEnum causesSafetyAccidentEnum) {
        this.name = name;
        this.accidentInfo = accidentInfo;
        this.causesSafetyAccidentEnum = causesSafetyAccidentEnum;
    }

    public CausesSafetyAccidentInfo toEntity(){
        return CausesSafetyAccidentInfo.builder()
                .name(name)
                .accidentInfo(accidentInfo)
                .causesSafetyAccidentEnum(causesSafetyAccidentEnum)
                .build();
    }
}
