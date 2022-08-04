package com.port.accident.portaccident.domain.training_scenario.scenario_evaluation;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.scenario_evaluation.ScenarioEvaluationDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "scenario_evaluation")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScenarioEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_evaluation_id") // 시나리오 평가 id
    private Integer id;

    @Column(name = "scenario_evaluation_name") // 시나리오명
    private String name;

    @Column(name = "scenario_evaluation_develop_standard")
    private SuitableCheck developmentStandard1;

    @Column(name = "scenario_evaluation_develop_standard2")
    private SuitableCheck developmentStandard2;

    @Column(name = "scenario_evaluation_possible_standard1")
    private SuitableCheck possibleStandard1;

    @Column(name = "scenario_evaluation_possible_standard2")
    private SuitableCheck possibleStandard2;

    @Column(name = "scenario_evaluation_complete_standard1")
    private SuitableCheck completeStandard1;

    @Column(name = "scenario_evaluation_complete_standard2")
    private SuitableCheck completeStandard2;

//    @OneToMany(mappedBy = "scenarioEvaluation")  // 시나리오 평가 기준
//    private List<ScenarioEvaluationStandard> scenarioEvaluationStandardList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_id") // 시나리오 id
    private Scenario scenario;

    @Builder
    public ScenarioEvaluation(Integer id, String name, Scenario scenario,
                              SuitableCheck developmentStandard1, SuitableCheck developmentStandard2,
                              SuitableCheck possibleStandard1, SuitableCheck possibleStandard2,
                              SuitableCheck completeStandard1, SuitableCheck completeStandard2) {
        this.id = id;
        this.name = name;
        this.developmentStandard1 = developmentStandard1;
        this.developmentStandard2 = developmentStandard2;
        this.possibleStandard1 = possibleStandard1;
        this.possibleStandard2 = possibleStandard2;
        this.completeStandard1 = completeStandard1;
        this.completeStandard2= completeStandard2;
        this.scenario = scenario;
    }

    @Transactional(readOnly = true)
    public void update(ScenarioEvaluationDto scenarioEvaluationDto) {
        this.developmentStandard1 = scenarioEvaluationDto.getDevelopmentStandard1();
        this.developmentStandard2 = scenarioEvaluationDto.getDevelopmentStandard2();
        this.possibleStandard1 = scenarioEvaluationDto.getPossibleStandard1();
        this.possibleStandard2 = scenarioEvaluationDto.getPossibleStandard2();
        this.completeStandard1 = scenarioEvaluationDto.getCompleteStandard1();
        this.completeStandard2= scenarioEvaluationDto.getCompleteStandard2();
    }
}