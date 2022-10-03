package com.port.accident.portaccident.dto.training_scenario.scenario_evaluation;


import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluation;
import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluationDetailsStandard;
import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluationStandard;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class ScenarioEvaluationStandardDto {
    private String name;
    private List<ScenarioEvaluationDetailsStandard> scenarioEvaluationDetailsStandardList = new ArrayList<>();
    private ScenarioEvaluation scenarioEvaluation;

    @Builder
    public ScenarioEvaluationStandardDto(String name, List<ScenarioEvaluationDetailsStandard> scenarioEvaluationDetailsStandardListt,
                                         ScenarioEvaluation scenarioEvaluation) {
        this.name = name;
        this.scenarioEvaluationDetailsStandardList = scenarioEvaluationDetailsStandardList;
        this.scenarioEvaluation = scenarioEvaluation;
    }

    public ScenarioEvaluationStandard toEntity() {
        return ScenarioEvaluationStandard.builder()
                .name(name)
                .scenarioEvaluationDetailsStandardList(scenarioEvaluationDetailsStandardList)
                .scenarioEvaluation(scenarioEvaluation)
                .build();
    }
}
