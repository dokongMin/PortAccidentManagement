package com.port.accident.portaccident.domain.training_scenario.scenario_evaluation;


import lombok.AccessLevel;
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
    @Column(name = "scenario_evaluation_standard_id")
    private Integer id;

    @Column(name = "scenario_evaluation_standard_name")
    private String name;

    @OneToMany(mappedBy = "scenario_evaluation_standard")
    private List<ScenarioEvaluationDetailsStandard> scenarioEvaluationDetailsStandardList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_evaluation_id")
    private ScenarioEvaluation scenarioEvaluation;
}
