package com.port.accident.portaccident.dto.training_scenario_result.evaluation;


import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.EvaluationDetails;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate;
import com.port.accident.portaccident.enums.CompletionStatus;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class TrainingByDateDto {
    private String details;
    private CompletionStatus completionCheck;
    private String evaluationName;
    private TrainingResult trainingResult;
//    private List<EvaluationDetails> evaluationDetailsList = new ArrayList<>();

    @Builder
    public TrainingByDateDto(String details, CompletionStatus completionCheck, String evaluationName, TrainingResult trainingResult) {
        this.details = details;
        this.completionCheck = completionCheck;
        this.evaluationName = evaluationName;
        this.trainingResult = trainingResult;
    }

    public TrainingByDate toEntity() {
        return TrainingByDate.builder()
                .details(details)
                .completionCheck(completionCheck)
                .evaluationName(evaluationName)
                .trainingResult(trainingResult)
                .build();
    }
}
