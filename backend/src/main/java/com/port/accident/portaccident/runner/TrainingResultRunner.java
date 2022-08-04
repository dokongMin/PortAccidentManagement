package com.port.accident.portaccident.runner;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentResponseActivityDto;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultDto;
import com.port.accident.portaccident.enums.*;
import com.port.accident.portaccident.service.ScenarioService;
import com.port.accident.portaccident.service.TrainingResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Profile("local")
@Component
public class TrainingResultRunner implements org.springframework.boot.ApplicationRunner{

    @Autowired
    TrainingResultService resultService;

    @Autowired
    ScenarioService scenarioService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        /* create scenario */
        //Given
        ScenarioDto scenarioDto = ScenarioDto.builder()
                .name("SY2")
                .level("3")
                .impact("경상")
                .precedingType("사고")
                .accidentType("추락")
                .portArea("무역항 수상구역")
                .responseStage("2")
                .build();

        AccidentPortFacilityDto accidentPortFacilityDto = AccidentPortFacilityDto.builder()
                .name("크레인")
                .build();

        AccidentPortFacilityDto accidentPortFacilityDto2 = AccidentPortFacilityDto.builder()
                .name("컨테이너")
                .build();

        AccidentResponseActivityDto accidentResponseActivityDto = AccidentResponseActivityDto.builder()
                .comment("사고가 발생한 상황을 가정하여 상세하게 작성.")
                .manager("홍길동")
                .completePlaningTime(LocalDateTime.now())
                .build();

        //When
        List<AccidentPortFacilityDto> accidentPortFacilityDtoList = new ArrayList<>();
        accidentPortFacilityDtoList.add(accidentPortFacilityDto);
        accidentPortFacilityDtoList.add(accidentPortFacilityDto2);

        List<AccidentResponseActivityDto> accidentResponseActivityDtoList = new ArrayList<>();
        accidentResponseActivityDtoList.add(accidentResponseActivityDto);

        Integer scenarioId = scenarioService.registerScenario(scenarioDto, accidentPortFacilityDtoList, accidentResponseActivityDtoList);
        Scenario scenario = scenarioService.findById(scenarioId).get();

        /* create TrainingResult */
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
                .scenario(scenario)
                .build();

        //when
        //then
        resultService.createTrainingResult(dto.toEntity());
    }
}
