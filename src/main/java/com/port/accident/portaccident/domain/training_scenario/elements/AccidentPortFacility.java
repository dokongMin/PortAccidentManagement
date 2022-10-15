package com.port.accident.portaccident.domain.training_scenario.elements;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.enums.PortFacility;
import lombok.AccessLevel;
import lombok.Builder;
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
    @Column(name = "accident_port_facility_id") // 안전 사고 항만 설비 id
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "accident_port_facility_name") // 안전 사고 항만 설비명
    private PortFacility name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_id") // 훈련 시나리오 id
    private Scenario scenario;

    @Builder
    public AccidentPortFacility(Integer id, PortFacility name, Scenario scenario) {
        this.id = id;
        this.name = name;
        this.scenario = scenario;
    }
}
