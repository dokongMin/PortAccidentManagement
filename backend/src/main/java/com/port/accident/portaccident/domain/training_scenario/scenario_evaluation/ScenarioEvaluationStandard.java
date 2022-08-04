package com.port.accident.portaccident.domain.training_scenario.scenario_evaluation;


import com.port.accident.portaccident.domain.training_scenario.Scenario;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "scenario_evaluation_standard")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScenarioEvaluationStandard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_evaluation_standard_id") // 시나리오 평가 기준 id
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "scenario_evaluation_standard_name")// 시나리오 평가 기준
    private EvaluationStandard evaluationStandard;

    @Column(name = "scenario_evaluation_details_standard_name") // 시나리오 평가 상세기준
    private String evaluationDetailsStandard;

    @Enumerated(EnumType.STRING)
    @Column(name = "suitable_check") // 상세기준별 적합 여부
    private SuitableCheck suitableCheck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_evaluation_id") // 시나리오 평가 id
    private ScenarioEvaluation scenarioEvaluation;


    @Builder
    public ScenarioEvaluationStandard(Integer id, EvaluationStandard evaluationStandard, String evaluationDetailsStandard,
                                      SuitableCheck suitableCheck, ScenarioEvaluation scenarioEvaluation) {
        this.id = id;
        this.evaluationStandard = evaluationStandard;
        this.evaluationDetailsStandard = evaluationDetailsStandard;
        this.suitableCheck = suitableCheck;
        this.scenarioEvaluation = scenarioEvaluation;
    }
}
