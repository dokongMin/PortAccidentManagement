package com.port.accident.portaccident.dto.training_scenario.scenario_evaluation;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluation;
import com.port.accident.portaccident.enums.SuitableCheck;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class ScenarioEvaluationDto {
    private Integer id;
    private String name;
    //    private List<ScenarioEvaluationStandard> scenarioEvaluationStandardList = new ArrayList<>();
    private SuitableCheck developmentStandard1;
    private SuitableCheck developmentStandard2;
    private SuitableCheck possibleStandard1;
    private SuitableCheck possibleStandard2;
    private SuitableCheck completeStandard1;
    private SuitableCheck completeStandard2;
    private Scenario scenario;

    @Builder
    public ScenarioEvaluationDto(Integer id, String name,
                                 SuitableCheck developmentStandard1, SuitableCheck developmentStandard2,
                                 SuitableCheck possibleStandard1, SuitableCheck possibleStandard2,
                                 SuitableCheck completeStandard1, SuitableCheck completeStandard2,
                                 Scenario scenario) {
        this.id = id;
        this.name = name;
        this.developmentStandard1 = developmentStandard1;
        this.developmentStandard2 = developmentStandard2;
        this.possibleStandard1 = possibleStandard1;
        this.possibleStandard2 = possibleStandard2;
        this.completeStandard1 = completeStandard1;
        this.completeStandard2 = completeStandard2;
        this.scenario = scenario;
    }

    public ScenarioEvaluation toEntity() {
        return ScenarioEvaluation.builder()
                .id(id)
                .name(name)
                .developmentStandard1(developmentStandard1)
                .developmentStandard2(developmentStandard2)
                .possibleStandard1(possibleStandard1)
                .possibleStandard2(possibleStandard2)
                .completeStandard1(completeStandard1)
                .completeStandard2(completeStandard2)
                .scenario(scenario)
                .build();
    }
}
