package com.port.accident.portaccident.dto.training_scenario.scenario_evaluation;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluation;
import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluationStandard;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class ScenarioEvaluationDto {
    private String name;
    private List<ScenarioEvaluationStandard> scenarioEvaluationStandardList = new ArrayList<>();
    private Scenario scenario;

    @Builder
    public ScenarioEvaluationDto(String name, List<ScenarioEvaluationStandard> scenarioEvaluationStandardList,
                                 Scenario scenario) {
        this.name = name;
        this.scenarioEvaluationStandardList = scenarioEvaluationStandardList;
        this.scenario = scenario;
    }

    public ScenarioEvaluation toEntity() {
        return ScenarioEvaluation.builder()
                .name(name)
                .scenarioEvaluationStandardList(scenarioEvaluationStandardList)
                .scenario(scenario)
                .build();
    }
}
