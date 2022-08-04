/*
package com.port.accident.portaccident.dto.training_scenario.scenario_evaluation;


import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.EvaluationStandard;
import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluation;
import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluationStandard;
import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.SuitableCheck;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class ScenarioEvaluationStandardDto {
    private EvaluationStandard evaluationStandard;
    private String evaluationDetailsStandard;
    private SuitableCheck suitableCheck;
    private ScenarioEvaluation scenarioEvaluation;

    @Builder
    public ScenarioEvaluationStandardDto(EvaluationStandard evaluationStandard, String evaluationDetailsStandard,
                                         SuitableCheck suitableCheck) {
        this.evaluationStandard = evaluationStandard;
        this.evaluationDetailsStandard = evaluationDetailsStandard;
        this.suitableCheck = suitableCheck;
    }

    public ScenarioEvaluationStandard toEntity() {
        return ScenarioEvaluationStandard.builder()
                .evaluationStandard(evaluationStandard)
                .evaluationDetailsStandard(evaluationDetailsStandard)
                .suitableCheck(suitableCheck)
                .scenarioEvaluation(scenarioEvaluation)
                .build();
    }
}
*/
