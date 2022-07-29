package com.port.accident.portaccident.domain.training_scenario.scenario_evaluation;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "scenario_evaluation")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScenarioEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_evaluation_id")
    private Integer id;

    @Column(name = "scenario_evaluation_name")
    private String name;

    @OneToMany(mappedBy = "scenarioEvaluation")
    private List<ScenarioEvaluationStandard> scenarioEvaluationStandardList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;

    @Builder
    public ScenarioEvaluation(Integer id, String name, List<ScenarioEvaluationStandard> scenarioEvaluationStandardList,
                              Scenario scenario) {
        this.id = id;
        this.name = name;
        this.scenarioEvaluationStandardList = scenarioEvaluationStandardList;
        this.scenario = scenario;
    }
}
