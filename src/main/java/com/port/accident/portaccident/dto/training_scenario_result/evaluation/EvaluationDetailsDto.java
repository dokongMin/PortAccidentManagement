package com.port.accident.portaccident.dto.training_scenario_result.evaluation;

import com.port.accident.portaccident.domain.training_scenario_result.evaluation.EvaluationDetails;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class EvaluationDetailsDto {
    private String name;
    private Integer score;
    private TrainingByDate trainingByDate;

    @Builder
    public EvaluationDetailsDto(String name, Integer score, TrainingByDate trainingByDate) {
        this.name = name;
        this.score = score;
        this.trainingByDate = trainingByDate;
    }

    public EvaluationDetails toEntity() {
        return EvaluationDetails.builder()
                .name(name)
                .score(score)
                .trainingByDate(trainingByDate)
                .build();
    }
}
