package com.port.accident.portaccident.domain.training_scenario.scenario;


import lombok.Getter;

import javax.persistence.*;

@Table(name = "scenario")
@Entity
@Getter
public class Scenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_id")
    private Integer id;

    @Column(name = "scenario_name")
    private String name;

    @Column(name = "scenario_level")
    private String level;

    @Column(name = "scenario_impact")
    private String impact;

    @Column(name = "scenario_type")
    private String type;

    @Column(name = "scenario_port_area")
    private String portArea;

    @Column(name = "scenario_response_stage")
    private String responseStage;


}
