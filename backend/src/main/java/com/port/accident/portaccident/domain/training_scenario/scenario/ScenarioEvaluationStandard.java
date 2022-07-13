package com.port.accident.portaccident.domain.training_scenario.scenario;


import lombok.Getter;

import javax.persistence.*;

@Table(name = "scenario_evaluation_standard")
@Entity
@Getter
public class ScenarioEvaluationStandard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_evaluation_standard")
    private Integer id;

    @Column(name = "scenario_evaluation_name")
    private String name;
}
