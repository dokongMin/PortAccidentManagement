package com.port.accident.portaccident.dto.training_scenario.scenario_evaluation;


import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluationDetailsStandard;
import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluationStandard;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class ScenarioEvaluationDetailsStandardDto {
    private String name;
    private Character suitableCheck;
    private ScenarioEvaluationStandard scenarioEvaluationStandard;

    @Builder
    public ScenarioEvaluationDetailsStandardDto(String name, Character suitableCheck,
                                                ScenarioEvaluationStandard scenarioEvaluationStandard) {
        this.name = name;
        this.suitableCheck = suitableCheck;
        this.scenarioEvaluationStandard = scenarioEvaluationStandard;
    }

    public ScenarioEvaluationDetailsStandard toEntity() {
        return ScenarioEvaluationDetailsStandard.builder()
                .name(name)
                .suitableCheck(suitableCheck)
                .scenarioEvaluationStandard(scenarioEvaluationStandard)
                .build();
    }
}
