package com.port.accident.portaccident.dto.training_scenario.elements;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class AccidentPortFacilityDto {
    private Integer id;
    private String name;
    private Scenario scenario;

    @Builder
    public AccidentPortFacilityDto(Integer id, String name, Scenario scenario) {
        this.id = id;
        this.name = name;
        this.scenario = scenario;
    }

    public AccidentPortFacility toEntity() {
        return AccidentPortFacility.builder()
                .id(id)
                .name(name)
                .scenario(scenario)
                .build();
    }
}
