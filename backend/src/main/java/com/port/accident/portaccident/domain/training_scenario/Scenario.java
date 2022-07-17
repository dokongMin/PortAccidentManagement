package com.port.accident.portaccident.domain.training_scenario;


import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluation;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "scenario")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    /**
     * precedingType : 사고 - 재난 둘 중에 어떤 유형인지 선택하기 위함
     */
    @Column(name = "accident_disaster_type")
    private String precedingType;

    @Column(name = "accident_type")
    private String accidentType;

    @Column(name = "disaster_type")
    private String disasterType;

    @Column(name = "scenario_port_area")
    private String portArea;

    @Column(name = "scenario_response_stage")
    private String responseStage;

    @OneToMany(mappedBy = "scenario")
    private List<AccidentPortFacility> accidentPortFacilityList = new ArrayList<>();

    @OneToMany(mappedBy = "scenario")
    private List<AccidentResponseActivity> accidentResponseActivityList = new ArrayList<>();

    @OneToMany(mappedBy = "scenario")
    private List<ScenarioEvaluation> scenarioEvaluationList = new ArrayList<>();
}
