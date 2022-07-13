package com.port.accident.portaccident.domain.training_scenario.scenario;

import lombok.Getter;

import javax.persistence.*;

@Table(name = "scenario_evaluation")
@Entity
@Getter
public class ScenarioEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_id")
    private Integer id;

    @Column(name = "scenario_name")
    private String name;
}
