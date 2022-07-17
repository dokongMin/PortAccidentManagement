package com.port.accident.portaccident.domain.training_scenario.elements;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "accident_port_facility")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccidentPortFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_port_facility_id")
    private Integer id;

    @Column(name = "accident_port_facility_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;
}
