package com.port.accident.portaccident.dto.training_scenario.elements;


import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity;
import com.port.accident.portaccident.enums.IncidentLevel;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class AccidentResponseActivityDto {
    private Integer id;
    private String comment;
    private String manager;
    private LocalDateTime completePlaningTime;

    private LocalDate completePlaningDate;
    private Scenario scenario;
    private Integer scenarioId;

    @Builder
    public AccidentResponseActivityDto(Integer id, String comment, String manager, LocalDateTime completePlaningTime, Scenario scenario) {
        this.id = id;
        this.comment = comment;
        this.manager = manager;
        this.completePlaningTime = completePlaningTime;
        this.scenario = scenario;
    }

    public AccidentResponseActivity toEntity() {
        return AccidentResponseActivity.builder()
                .id(id)
                .comment(comment)
                .manager(manager)
                .completePlaningTime(completePlaningTime)
                .scenario(scenario)
                .build();
    }
}
