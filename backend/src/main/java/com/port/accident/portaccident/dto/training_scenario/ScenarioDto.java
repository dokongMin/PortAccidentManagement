package com.port.accident.portaccident.dto.training_scenario;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity;
import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluation;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class ScenarioDto {
    private String name;
    private String level;
    private String impact;
    private String precedingType;
    private String accidentType;
    private String disasterType;
    private String portArea;
    private String responseStage;
    private List<AccidentPortFacility> accidentPortFacilityList = new ArrayList<>();
    private List<AccidentResponseActivity> accidentResponseActivityList = new ArrayList<>();
    private List<ScenarioEvaluation> scenarioEvaluationList = new ArrayList<>();

    @Builder
    public ScenarioDto(String name, String level, String impact, String precedingType, String accidentType,
                       String disasterType, String portArea, String responseStage,
                       List<AccidentPortFacility> accidentPortFacilityList,
                       List<AccidentResponseActivity> accidentResponseActivityList,
                       List<ScenarioEvaluation> scenarioEvaluationList) {
        this.name = name;
        this.level = level;
        this.impact = impact;
        this.precedingType = precedingType;
        this.accidentType = accidentType;
        this.disasterType = disasterType;
        this.portArea = portArea;
        this.responseStage = responseStage;
        this.accidentPortFacilityList = accidentPortFacilityList;
        this.accidentResponseActivityList = accidentResponseActivityList;
        this.scenarioEvaluationList = scenarioEvaluationList;
    }

    public Scenario toEntity() {
        return Scenario.builder()
                .name(name)
                .level(level)
                .impact(impact)
                .precedingType(precedingType)
                .accidentType(accidentType)
                .disasterType(disasterType)
                .portArea(portArea)
                .responseStage(responseStage)
                .accidentPortFacilityList(accidentPortFacilityList)
                .accidentResponseActivityList(accidentResponseActivityList)
                .scenarioEvaluationList(scenarioEvaluationList)
                .build();
    }
}
