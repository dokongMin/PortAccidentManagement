package com.port.accident.portaccident.dto.accident_management.elements;


import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccident;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class CausesSafetyAccidentDto {
    private String name;
    private List<AccidentInfo> accidentInfoList = new ArrayList<>();


    @Builder
    public CausesSafetyAccidentDto(String name, List<AccidentInfo> accidentInfoList) {
        this.name = name;
        this.accidentInfoList = accidentInfoList;
    }

    public CausesSafetyAccident toEntity() {
        return CausesSafetyAccident.builder()
                .name(name)
                .accidentInfoList(accidentInfoList)
                .build();
    }
}
