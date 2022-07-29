package com.port.accident.portaccident.domain.training_scenario.scenario_evaluation;


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

    @Column(name = "scenario_evaluation_standard_name") // 평가 기준명
    private String name;

    @OneToMany(mappedBy = "scenarioEvaluationStandard") // 시나리오 평가 상세기준
    private List<ScenarioEvaluationDetailsStandard> scenarioEvaluationDetailsStandardList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_evaluation_id") // 시나리오 평가 id
    private ScenarioEvaluation scenarioEvaluation;

    @Builder
    public ScenarioEvaluationStandard(Integer id, String name,
                                      List<ScenarioEvaluationDetailsStandard> scenarioEvaluationDetailsStandardList,
                                      ScenarioEvaluation scenarioEvaluation) {
        this.id = id;
        this.name = name;
        this.scenarioEvaluationDetailsStandardList = scenarioEvaluationDetailsStandardList;
        this.scenarioEvaluation = scenarioEvaluation;
    }
}
