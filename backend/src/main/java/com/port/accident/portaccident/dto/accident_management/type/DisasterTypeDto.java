package com.port.accident.portaccident.dto.accident_management.type;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.type.DisasterType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class DisasterTypeDto {
    private Integer id;
    private String name;
    private List<AccidentInfo> accidentInfoList = new ArrayList<>();

    @Builder
    public DisasterTypeDto(Integer id, String name, List<AccidentInfo> accidentInfoList) {
        this.id = id;
        this.name = name;
        this.accidentInfoList = accidentInfoList;
    }



    public DisasterType toEntity() {
        return DisasterType.builder()
                .name(name)
                .accidentInfoList(accidentInfoList)
                .build();
    }
}
