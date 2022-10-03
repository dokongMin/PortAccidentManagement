package com.port.accident.portaccident.repository.training_scenario_result;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultCondition;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultDto;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultJoinScenarioDto;
import com.port.accident.portaccident.enums.*;
import com.port.accident.portaccident.repository.training_scenario.ScenarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrainingResultRepositoryTest {

    @Autowired
    TrainingResultRepository resultRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Before
    public void setup() {
        /* create scenario */
        ScenarioDto scenarioDto = ScenarioDto.builder()
                .name("SY2")
                .incidentImpact(IncidentImpact.INCIDENT_IMPACT_A)
                .incidentType(IncidentType.INCIDENT)
                .incidentDetailType("추락")
                .portArea("무역항 수상구역")
                .responseStage("2")
                .build();

        Scenario scenario = scenarioRepository.save(scenarioDto.toEntity());

        /* create TrainingResult */
        TrainingResultDto resultDto1 = TrainingResultDto.builder()
                .name("대응훈련결과명1")
                .startDate(LocalDateTime.of(2022, 3, 10, 12, 00))
                .endDate(LocalDateTime.of(2022, 3, 12, 12, 00))
                .place(TrainingPlace.PLACE1)
                .trainingType(TrainingType.VIRTUAL)
                .incidentLevel(IncidentLevel.LEVEL_1)
                .incidentImpact(IncidentImpact.INCIDENT_IMPACT_A)
                .incidentType(IncidentType.INCIDENT)
                .department("안전관리부서")
                .trainingArea("훈련대상 항만구역")
                .scenario(scenario)
                .build();

        TrainingResultDto resultDto2 = TrainingResultDto.builder()
                .name("대응훈련결과명2")
                .startDate(LocalDateTime.of(2022, 3, 10, 12, 00))
                .endDate(LocalDateTime.of(2022, 3, 12, 12, 00))
                .place(TrainingPlace.PLACE2)
                .trainingType(TrainingType.ACTUAL)
                .incidentLevel(IncidentLevel.LEVEL_2)
                .incidentImpact(IncidentImpact.INCIDENT_IMPACT_B)
                .incidentType(IncidentType.INCIDENT)
                .department("안전관리부서2")
                .trainingArea("훈련대상 항만구역")
                .scenario(scenario)
                .build();

        TrainingResultDto resultDto3 = TrainingResultDto.builder()
                .name("대응훈련결과명3")
                .startDate(LocalDateTime.of(2022, 3, 10, 12, 00))
                .endDate(LocalDateTime.of(2022, 3, 12, 12, 00))
                .place(TrainingPlace.PLACE2)
                .trainingType(TrainingType.ACTUAL)
                .incidentLevel(IncidentLevel.LEVEL_1)
                .incidentImpact(IncidentImpact.INCIDENT_IMPACT_A)
                .incidentType(IncidentType.DISASTER)
                .department("안전관리부서")
                .trainingArea("훈련대상 항만구역2")
                .scenario(scenario)
                .build();
        resultRepository.save(resultDto1.toEntity());
        resultRepository.save(resultDto2.toEntity());
        resultRepository.save(resultDto3.toEntity());
    }

    @Test
    public void searchPageTrainingResult() {
        //given
        TrainingResultCondition condition = new TrainingResultCondition();
        condition.setIncidentLevel(IncidentLevel.LEVEL_1);
        PageRequest pageRequest = PageRequest.of(0,2);  //0페이지부터 시작해서 3개씩 가져옴

        //when
        Page<TrainingResultJoinScenarioDto> result = resultRepository.searchPageTrainingResults(condition, pageRequest);

        //then
        assertEquals(result.getSize(),2);
        assertEquals(result.getContent().get(0).getIncidentLevel(),IncidentLevel.LEVEL_1);
        assertEquals(result.getContent().get(1).getIncidentLevel(),IncidentLevel.LEVEL_1);
    }



}