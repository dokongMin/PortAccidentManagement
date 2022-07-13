package com.port.accident.portaccident.domain.training_scenario.scenario_activity;

import lombok.Getter;

import javax.persistence.*;

@Table(name = "accident_port_area")
@Entity
@Getter
public class AccidentPortArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_port_area_id")
    private Integer id;

    @Column(name = "accident_port_area_name")
    private String name;
}
