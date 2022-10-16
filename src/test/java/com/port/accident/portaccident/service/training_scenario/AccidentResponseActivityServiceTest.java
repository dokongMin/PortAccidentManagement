package com.port.accident.portaccident.service.training_scenario;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentResponseActivityDto;
import com.port.accident.portaccident.enums.*;
import com.port.accident.portaccident.repository.training_scenario.AccidentResponseActivityRepository;
import com.port.accident.portaccident.repository.training_scenario.ScenarioRepository;
import com.port.accident.portaccident.service.ScenarioService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class AccidentResponseActivityServiceTest {

    @Autowired
    ScenarioService scenarioService;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    AccidentResponseActivityRepository accidentResponseActivityRepository;

    Integer scenarioId;

    @Before
    public void 시나리오_등록() {
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

        List<AccidentPortFacilityDto> accidentPortFacilityDtoList = new ArrayList<>();
        accidentPortFacilityDtoList.add(accidentPortFacilityDto);
        accidentPortFacilityDtoList.add(accidentPortFacilityDto2);

        scenarioId = scenarioService.registerScenario(scenarioDto, accidentPortFacilityDtoList);
    }


    @Test
    public void 안전사고_대응활동_등록() {
        //given
        AccidentResponseActivityDto accidentResponseActivityDto = AccidentResponseActivityDto.builder()
                .comment("사고가 발생한 상황을 가정하여 상세하게 작성.")
                .manager("이혜원")
                .completePlaningTime(LocalDateTime.now())
                .build();

        //when
        Integer activityId = scenarioService.registerAccidentResponseActivity(scenarioId, accidentResponseActivityDto);

        //then
        Scenario scenario = scenarioRepository.findById(scenarioId).get();

        AccidentResponseActivity accidentResponseActivity = accidentResponseActivityRepository.findById(activityId).get();
        List<AccidentResponseActivity> accidentResponseActivityList = accidentResponseActivityRepository.findAll();

        assertEquals(1, accidentResponseActivityList.size());
        assertEquals(accidentResponseActivityDto.getManager(), accidentResponseActivity.getManager());
        assertEquals(scenario.getName(), accidentResponseActivity.getScenario().getName());
    }

    @Test
    public void 안전사고_대응활동_수정() {
        //given
        AccidentResponseActivityDto accidentResponseActivityDto = AccidentResponseActivityDto.builder()
                .comment("사고가 발생한 상황을 가정하여 상세하게 작성.")
                .manager("이혜원")
                .completePlaningTime(LocalDateTime.now())
                .build();

        Integer activityId = scenarioService.registerAccidentResponseActivity(scenarioId, accidentResponseActivityDto);

        AccidentResponseActivityDto updateAccidentResponseActivityDto = AccidentResponseActivityDto.builder()
                .id(activityId)
                .comment("사고가 발생한 상황을 가정하여 상세하게 작성.")
                .manager("홍길동")
                .completePlaningTime(LocalDateTime.now())
                .build();

        //when
        Integer updateActivityId = scenarioService.updateAccidentResponseActivity(updateAccidentResponseActivityDto);

        //then
        AccidentResponseActivity updateScenarioEvaluation = accidentResponseActivityRepository.findById(updateActivityId).get();
        List<AccidentResponseActivity> accidentResponseActivityList = accidentResponseActivityRepository.findAll();

        assertEquals(activityId, updateActivityId);
        assertEquals(updateAccidentResponseActivityDto.getComment(), updateScenarioEvaluation.getComment());
        assertEquals(updateAccidentResponseActivityDto.getManager(), updateScenarioEvaluation.getManager());
        assertEquals(updateAccidentResponseActivityDto.getCompletePlaningTime(), updateScenarioEvaluation.getCompletePlaningTime());
        assertEquals(1, accidentResponseActivityList.size());
    }

    @Test
    public void 안전사고_대응활동_삭제() {
        //given
        AccidentResponseActivityDto accidentResponseActivityDto = AccidentResponseActivityDto.builder()
                .comment("사고가 발생한 상황을 가정하여 상세하게 작성.")
                .manager("이혜원")
                .completePlaningTime(LocalDateTime.now())
                .build();

        Integer activityId = scenarioService.registerAccidentResponseActivity(scenarioId, accidentResponseActivityDto);

        //when
        scenarioService.deleteAccidentResponseActivity(activityId);

        //then
        Optional<AccidentResponseActivity> deleteAccidentResponseActivity = accidentResponseActivityRepository.findById(activityId);
        assertFalse(deleteAccidentResponseActivity.isPresent());
    }
}
