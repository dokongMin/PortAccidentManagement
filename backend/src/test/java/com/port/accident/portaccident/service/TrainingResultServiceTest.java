package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.EvaluationDetails;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultDto;
import com.port.accident.portaccident.dto.training_scenario_result.elements.TrainingParticipantsDto;
import com.port.accident.portaccident.dto.training_scenario_result.elements.TrainingPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario_result.evaluation.EvaluationDetailsDto;
import com.port.accident.portaccident.dto.training_scenario_result.evaluation.TrainingByDateDto;
import com.port.accident.portaccident.enums.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class TrainingResultServiceTest {

    @Autowired
    TrainingResultService resultService;

    Integer trainingResultId = 0;

    @Before
    public void createTrainingResult() {
        //given
        TrainingResultDto dto = TrainingResultDto.builder()
                .name("대응훈련결과명")
                .startDate(LocalDateTime.of(2022, 3, 10, 12, 00))
                .endDate(LocalDateTime.of(2022, 3, 12, 12, 00))
                .place(TrainingPlace.PLACE1)
                .trainingType(TrainingType.ACTUAL)
                .incidentLevel(IncidentLevel.LEVEL_1)
                .incidentImpact(IncidentImpact.INCIDENT_IMPACT_A)
                .incidentType(IncidentType.ACCIDNET)
                .department("안전관리부서")
                .trainingArea("훈련대상 항만구역")
                .build();

        //when
        //then
        trainingResultId = resultService.createTrainingResult(dto.toEntity());
    }

    @Test
    public void createTrainingParticipants() {
        //given
        TrainingResult trainingResult = resultService.findByTrainingResultId(trainingResultId);

        TrainingParticipantsDto dto = TrainingParticipantsDto.builder()
                .participantsId(1)
                .trainingResult(trainingResult)
                .build();

        //when
        Integer participantId = resultService.createTrainingParticipants(dto.toEntity());
        TrainingParticipants participants = resultService.findByParticipantId(participantId);

        //then
        assertEquals(participants.getParticipantsId(), 1);
        assertEquals(participants.getTrainingResult().getId(), trainingResultId);

    }

    @Test
    public void createPortFacility() {
        //given
        TrainingResult trainingResult = resultService.findByTrainingResultId(trainingResultId);

        TrainingPortFacilityDto dto = TrainingPortFacilityDto.builder()
                .name(PortFacility.CONTAINER)
                .trainingResult(trainingResult)
                .build();

        //when
        Integer facilityId = resultService.createPortFacility(dto.toEntity());
        TrainingPortFacility facility = resultService.findByFacilityId(facilityId);

        //then
        assertEquals(facility.getName(), PortFacility.CONTAINER);
        assertEquals(facility.getTrainingResult().getId(), trainingResultId);

    }

    @Test
    public void createTrainingByDate() {
        //given
        TrainingResult trainingResult = resultService.findByTrainingResultId(trainingResultId);

        TrainingByDateDto dto = TrainingByDateDto.builder()
                .details("1일차 대응훈련 수행 내용")
                .completionCheck(CompletionStatus.COMPLETE)
                .evaluationName("대응훈련 평가항목명")
                .trainingResult(trainingResult)
                .build();

        //when
        Integer resultByDateId = resultService.createTrainingByDate(dto.toEntity());
        TrainingByDate resultByDate = resultService.findTrainingByDate(resultByDateId);

        //then
        assertEquals(resultByDate.getCompletionCheck(), CompletionStatus.COMPLETE);
        assertEquals(resultByDate.getTrainingResult().getId(), trainingResultId);
    }

    @Test
    public void createEvaluationDetails() {
        //given
        /* create TrainingByDate */
        TrainingResult trainingResult = resultService.findByTrainingResultId(trainingResultId);

        TrainingByDateDto byDateDto = TrainingByDateDto.builder()
                .details("1일차 대응훈련 수행 내용")
                .completionCheck(CompletionStatus.COMPLETE)
                .evaluationName("대응훈련 평가항목명")
                .trainingResult(trainingResult)
                .build();

        Integer resultByDateId = resultService.createTrainingByDate(byDateDto.toEntity());
        TrainingByDate resultByDate = resultService.findTrainingByDate(resultByDateId);

        /* create EvaluationDetails */
        EvaluationDetailsDto detailsDto = EvaluationDetailsDto.builder()
                .name("훈련평가상세항목명")
                .score(5)
                .trainingByDate(resultByDate)
                .build();

        //when
        Integer detailId = resultService.createEvaluationDetails(detailsDto.toEntity());
        EvaluationDetails details = resultService.findByEvaluationDetailId(detailId);

        //then
        assertEquals(details.getScore(), 5);
        assertEquals(details.getTrainingByDate().getId(), resultByDateId);


    }
}