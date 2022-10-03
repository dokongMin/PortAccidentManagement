package com.port.accident.portaccident.dto.training_scenario_result.elements;

import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class TrainingParticipantsDto {
    private Integer participantsId;
    private TrainingResult trainingResult;

    @Builder
    public TrainingParticipantsDto(Integer participantsId, TrainingResult trainingResult) {
        this.participantsId = participantsId;
        this.trainingResult = trainingResult;
    }

    public TrainingParticipants toEntity() {
        return TrainingParticipants.builder()
                .participantsId(participantsId)
                .trainingResult(trainingResult)
                .build();
    }
}
