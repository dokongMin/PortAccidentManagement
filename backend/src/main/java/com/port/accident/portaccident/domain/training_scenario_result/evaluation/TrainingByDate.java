package com.port.accident.portaccident.domain.training_scenario_result.evaluation;

import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "training_by_date")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TrainingByDate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_by_date_id")
    private Integer id;

    @Column(name = "training_details")
    private String details;

    @Column(name = "training_completion_check")
    private Character completionCheck;

    @Column(name = "training_evaluation_name")
    private String evaluationName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_result_id")
    private TrainingResult trainingResult;

    @OneToMany(mappedBy = "training_by_date")
    private List<EvaluationDetails> evaluationDetailsList = new ArrayList<>();
}
