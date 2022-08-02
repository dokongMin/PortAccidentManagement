package com.port.accident.portaccident.domain.training_scenario_result.evaluation;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "evaluation_details")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EvaluationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_details_id")
    private Integer id;

    @Column(name = "evaluation_details_name")
    private String name;

    @Column(name = "evaluation_details_score")
    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_by_date_id")
    private TrainingByDate trainingByDate;

    @Builder
    public EvaluationDetails(Integer id, String name, Integer score, TrainingByDate trainingByDate) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.trainingByDate = trainingByDate;
    }
}
