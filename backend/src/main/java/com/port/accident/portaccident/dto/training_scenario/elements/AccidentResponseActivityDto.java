package com.port.accident.portaccident.dto.training_scenario.elements;


import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity;
import com.port.accident.portaccident.enums.IncidentLevel;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class AccidentResponseActivityDto {
    private IncidentLevel incidentLevel;
    private String comment;
    private String manager;
    private LocalDateTime completePlaningTime;
    private Scenario scenario;

    @Builder
    public AccidentResponseActivityDto(IncidentLevel incidentLevel, String comment, String manager, LocalDateTime completePlaningTime, Scenario scenario) {
        this.incidentLevel = incidentLevel;
        this.comment = comment;
        this.manager = manager;
        this.completePlaningTime = completePlaningTime;
        this.scenario = scenario;
    }

    public AccidentResponseActivity toEntity() {
        return AccidentResponseActivity.builder()
                .incidentLevel(incidentLevel)
                .comment(comment)
                .manager(manager)
                .completePlaningTime(completePlaningTime)
                .scenario(scenario)
                .build();
    }
}
