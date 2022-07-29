package com.port.accident.portaccident.domain.training_scenario.scenario_evaluation;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "scenario_evlauation_details_standard")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScenarioEvaluationDetailsStandard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_evaluation_details_standard_id")
    private Integer id;


    @Column(name = "scenario_evaluation_details_standard_name")
    private String name;

    @Column(name = "suitable_check")
    private Character suitableCheck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_evaluation_standard_id")
    private ScenarioEvaluationStandard scenarioEvaluationStandard;

    @Builder
    public ScenarioEvaluationDetailsStandard(Integer id, String name, Character suitableCheck,
                                             ScenarioEvaluationStandard scenarioEvaluationStandard) {
        this.id = id;
        this.name = name;
        this.suitableCheck = suitableCheck;
        this.scenarioEvaluationStandard = scenarioEvaluationStandard;
    }
}
