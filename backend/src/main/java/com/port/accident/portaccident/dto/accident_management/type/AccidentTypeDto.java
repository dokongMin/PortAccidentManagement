package com.port.accident.portaccident.dto.accident_management.type;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class AccidentTypeDto {
    private String name;
    private List<AccidentInfo> accidentInfoList = new ArrayList<>();


    @Builder
    public AccidentTypeDto(String name, List<AccidentInfo> accidentInfoList) {
        this.name = name;
        this.accidentInfoList = accidentInfoList;
    }


    public AccidentType toEntity() {
        return AccidentType.builder()
                .name(name)
                .accidentInfoList(accidentInfoList)
                .build();
    }
}
