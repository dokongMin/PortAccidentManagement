package com.port.accident.portaccident.domain.training_scenario_result.elements;


import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "training_port_facility")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TrainingPortFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_port_facility_id")
    private Integer id;

    @Column(name = "training_port_facility_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_result_id")
    private TrainingResult trainingResult;
}
