package com.port.accident.portaccident.dto.training_scenario_result.elements;


import com.port.accident.portaccident.domain.staff.Staff;
import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility;
import com.port.accident.portaccident.enums.PortFacility;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class TrainingPortFacilityDto {
    private Integer id;
    private PortFacility name;
    private TrainingResult trainingResult;

    @Builder
    public TrainingPortFacilityDto(Integer id, PortFacility name, TrainingResult trainingResult) {
        this.id = id;
        this.name = name;
        this.trainingResult = trainingResult;
    }

    public TrainingPortFacility toEntity() {
        return TrainingPortFacility.builder()
                .id(id)
                .name(name)
                .trainingResult(trainingResult)
                .build();
    }
}
