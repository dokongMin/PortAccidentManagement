package com.port.accident.portaccident.repository.training_scenario_result.element;

import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultDto;
import com.port.accident.portaccident.dto.training_scenario_result.elements.TrainingParticipantsDto;
import com.port.accident.portaccident.dto.training_scenario_result.elements.TrainingPortFacilityDto;
import com.port.accident.portaccident.enums.*;
import com.port.accident.portaccident.repository.training_scenario_result.TrainingResultRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrainingPortFacilityRepositoryTest {

    @Autowired
    TrainingResultRepository resultRepository;

    @Autowired
    TrainingPortFacilityRepository facilityRepository;

    Integer trainingResultId = 0;

    @Before
    public void setup() {
        TrainingResultDto resultDto = TrainingResultDto.builder()
                .name("대응훈련결과명")
                .startDate(LocalDateTime.of(2022, 3, 10, 12, 00))
                .endDate(LocalDateTime.of(2022, 3, 12, 12, 00))
                .place(TrainingPlace.PLACE1)
                .trainingType(TrainingType.ACTUAL)
                .incidentLevel(IncidentLevel.LEVEL_1)
                .incidentImpact(IncidentImpact.DAMAGE)
                .incidentType(IncidentType.INCIDENT)
                .incidentDetailType("추락")
                .department("안전관리부서A")
                .trainingArea("훈련대상 항만구역 A")
                .build();
        TrainingResult trainingResult = resultRepository.save(resultDto.toEntity());
        trainingResultId = trainingResult.getId();

        TrainingPortFacilityDto facilityDto1 = TrainingPortFacilityDto.builder()
                .name(PortFacility.CONTAINER)
                .trainingResult(trainingResult)
                .build();
        TrainingPortFacilityDto facilityDto2 = TrainingPortFacilityDto.builder()
                .name(PortFacility.FORKLIFT)
                .trainingResult(trainingResult)
                .build();

        //when
        facilityRepository.save(facilityDto1.toEntity());
        facilityRepository.save(facilityDto2.toEntity());

        /* create TrainingParticipants */
        //given
//        TrainingParticipantsDto participantsDto = TrainingParticipantsDto.builder()
//                .participantsId(1)
//                .trainingResult(trainingResult)
//                .build();
//
//        //when
//        resultService.createTrainingParticipants(participantsDto.toEntity());
    }

    @Test
    public void deleteFacilityByIdTest() {
        //when
        facilityRepository.deleteFacilityByTrainingResultId(trainingResultId);

        //then

        Assertions.assertThat( facilityRepository.findAll().size()).isEqualTo(0);

    }

}