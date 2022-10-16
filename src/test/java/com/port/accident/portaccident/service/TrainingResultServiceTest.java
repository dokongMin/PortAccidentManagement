package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.EvaluationDetails;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultDto;
import com.port.accident.portaccident.dto.training_scenario_result.elements.TrainingParticipantsDto;
import com.port.accident.portaccident.dto.training_scenario_result.elements.TrainingPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario_result.evaluation.EvaluationDetailsDto;
import com.port.accident.portaccident.dto.training_scenario_result.evaluation.TrainingByDateDto;
import com.port.accident.portaccident.enums.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class TrainingResultServiceTest {

    @Autowired
    TrainingResultService resultService;

    @Autowired
    ScenarioService scenarioService;

    Integer trainingResultId = 0;

    @Before
    public void createTrainingResult() {
        /* create scenario */
        //Given
        ScenarioDto scenarioDto = ScenarioDto.builder()
                .name("SY2")
                .incidentLevel(IncidentLevel.LEVEL_3)
                .incidentImpact(IncidentImpact.DAMAGE)
                .incidentType(IncidentType.INCIDENT)
                .incidentDetailType(IncidentDetailType.DROP)
                .portArea(TrainingPlace.PLACE1)
                .build();

        AccidentPortFacilityDto accidentPortFacilityDto = AccidentPortFacilityDto.builder()
                .name(PortFacility.CRANE)
                .build();

        AccidentPortFacilityDto accidentPortFacilityDto2 = AccidentPortFacilityDto.builder()
                .name(PortFacility.CONTAINER)
                .build();

        //When
        List<AccidentPortFacilityDto> accidentPortFacilityDtoList = new ArrayList<>();
        accidentPortFacilityDtoList.add(accidentPortFacilityDto);
        accidentPortFacilityDtoList.add(accidentPortFacilityDto2);

        Integer scenarioId = scenarioService.registerScenario(scenarioDto, accidentPortFacilityDtoList);
        Scenario scenario = scenarioService.findById(scenarioId);

        /* create TrainingResult */
        //given
        TrainingResultDto dto = TrainingResultDto.builder()
                .name("대응훈련결과명")
                .startDate(LocalDateTime.of(2022, 3, 10, 12, 00))
                .endDate(LocalDateTime.of(2022, 3, 12, 12, 00))
                .place(TrainingPlace.PLACE1)
                .trainingType(TrainingType.ACTUAL)
                .incidentLevel(IncidentLevel.LEVEL_1)
                .incidentImpact(IncidentImpact.DAMAGE)
                .incidentType(IncidentType.INCIDENT)
                .department("안전관리부서")
                .trainingArea("훈련대상 항만구역")
                .scenario(scenario)
                .build();

        //when
        //then
        trainingResultId = resultService.createTrainingResult(dto.toEntity());
    }

    @Test
    public void duplicateTrainingResultName() {
        //given
        TrainingResultDto dto = TrainingResultDto.builder()
                .name("대응훈련결과명")
                .build();

        //when
        try {
            resultService.createTrainingResult(dto.toEntity());
        } catch (RuntimeException e) {
            //then
            Assertions.assertEquals("훈련명(name)은 유니크한 값이여야 합니다.", e.getMessage());
        }

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
        assertEquals(java.util.OptionalInt.of(participants.getParticipantsId()), OptionalInt.of(1));
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
        TrainingByDate resultByDate = resultService.findTrainingByDateById(resultByDateId);

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
        TrainingByDate resultByDate = resultService.findTrainingByDateById(resultByDateId);

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
        assertEquals(java.util.OptionalInt.of(details.getScore()), OptionalInt.of(5));
        assertEquals(details.getTrainingByDate().getId(), resultByDateId);

    }

    @Test
    public void updateTrainingResultServiceTest() {

    }

}