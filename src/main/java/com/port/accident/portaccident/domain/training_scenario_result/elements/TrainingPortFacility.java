package com.port.accident.portaccident.domain.training_scenario_result.elements;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.enums.PortFacility;
import lombok.AccessLevel;
import lombok.Builder;
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

    @Enumerated(value = EnumType.STRING)
    @Column(name = "training_port_facility_name")
    private PortFacility name;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_result_id")
    private TrainingResult trainingResult;

    @Builder
    public TrainingPortFacility(Integer id, PortFacility name, TrainingResult trainingResult) {
        this.id = id;
        this.name = name;
        this.trainingResult = trainingResult;
    }
}
