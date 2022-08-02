package com.port.accident.portaccident.dto.training_scenario_result.evaluation;


import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.EvaluationDetails;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class TrainingByDateDto {
    private String details;
    private Character completionCheck;
    private String evaluationName;
    private TrainingResult trainingResult;
    private List<EvaluationDetails> evaluationDetailsList = new ArrayList<>();

    @Builder
    public TrainingByDateDto(String details, Character completionCheck, String evaluationName,
                             TrainingResult trainingResult, List<EvaluationDetails> evaluationDetailsList) {
        this.details = details;
        this.completionCheck = completionCheck;
        this.evaluationName = evaluationName;
        this.trainingResult = trainingResult;
        this.evaluationDetailsList = evaluationDetailsList;
    }

    public TrainingByDate toEntity() {
        return TrainingByDate.builder()
                .details(details)
                .completionCheck(completionCheck)
                .evaluationName(evaluationName)
                .trainingResult(trainingResult)
                .evaluationDetailsList(evaluationDetailsList)
                .build();
    }
}
