package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
import com.port.accident.portaccident.repository.training_scenario.AccidentPortFacilityRepository;
import com.port.accident.portaccident.repository.training_scenario.ScenarioRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
//@Rollback(value = false)
public class TrainingScenarioServiceTest {

    @Autowired
    ScenarioService scenarioService;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    AccidentPortFacilityRepository accidentPortFacilityRepository;

    @Test
    public void 시나리오_등록() {
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

        //When
        Integer scenarioId = scenarioService.saveScenario(scenarioDto);

        Scenario scenario = scenarioRepository.findById(scenarioId).get();
        accidentPortFacilityDto.setScenario(scenario);
        accidentPortFacilityDto2.setScenario(scenario);

        Integer accidentPortFacilityDtoId = scenarioService.saveAccidentPortFacility(accidentPortFacilityDto);
        Integer accidentPortFacilityDtoId2 = scenarioService.saveAccidentPortFacility(accidentPortFacilityDto2);

        //Then
        assertEquals(scenarioDto.toEntity().getName(), scenario.getName());
        assertEquals(accidentPortFacilityDto.toEntity().getName(), accidentPortFacilityRepository.findById(accidentPortFacilityDtoId).get().getName());
        assertEquals(accidentPortFacilityDto2.toEntity().getName(), accidentPortFacilityRepository.findById(accidentPortFacilityDtoId2).get().getName());

        List<AccidentPortFacility> accidentPortFacilityList = accidentPortFacilityRepository.findAll();
        assertEquals(2, accidentPortFacilityList.size());
        assertEquals(scenarioId, accidentPortFacilityList.get(0).getScenario().getId());
        assertEquals(scenarioId, accidentPortFacilityList.get(1).getScenario().getId());

    }

    @Test(expected = IllegalStateException.class)
    public void 시나리오_중복_예외() {
        //Given
        ScenarioDto scenarioDto = ScenarioDto.builder()
                .name("SY2")
                .build();

        ScenarioDto scenarioDto2 = ScenarioDto.builder()
                .name("SY2")
                .build();

        //When
        scenarioService.saveScenario(scenarioDto);
        scenarioService.saveScenario(scenarioDto2); // 예외 발생

        //Then
        fail("이미 존재하는 시나리오입니다.");
    }

    @Test
    public void 시나리오_수정() {
        //given
        ScenarioDto scenarioDto = ScenarioDto.builder()
                .name("SY2")
                .level("3")
                .impact("경상")
                .precedingType("사고")
                .accidentType("추락")
                .portArea("무역항 수상구역")
                .responseStage("2")
                .build();

        Integer scenarioId = scenarioService.saveScenario(scenarioDto);

        ScenarioDto updateScenarioDto = ScenarioDto.builder()
                .name("SY2")
                .level("1")
                .impact("중상")
                .precedingType("사고")
                .accidentType("넘어짐")
                .portArea("무역항 수상구역")
                .responseStage("2")
                .build();

        //when
        Integer updateScenarioId = scenarioService.updateScenario(updateScenarioDto);

        //then
        Scenario updateScenario = scenarioRepository.findById(updateScenarioId).get();

        Assertions.assertEquals(scenarioId, updateScenarioId);
        Assertions.assertEquals(updateScenarioDto.toEntity().getName(), updateScenario.getName());
        Assertions.assertEquals(updateScenarioDto.toEntity().getLevel(), updateScenario.getLevel());
        Assertions.assertEquals(updateScenarioDto.toEntity().getImpact(), updateScenario.getImpact());
        Assertions.assertEquals(updateScenarioDto.toEntity().getAccidentType(), updateScenario.getAccidentType());
    }

    @Test
    public void 안전사고_항만설비_수정() {
        //given
        ScenarioDto scenarioDto = ScenarioDto.builder()
                .name("SY2")
                .build();

        AccidentPortFacilityDto accidentPortFacilityDto = AccidentPortFacilityDto.builder()
                .name("크레인")
                .scenario(scenarioDto.toEntity())
                .build();

        AccidentPortFacilityDto accidentPortFacilityDto2 = AccidentPortFacilityDto.builder()
                .name("컨테이너")
                .scenario(scenarioDto.toEntity())
                .build();

        List<AccidentPortFacilityDto> accidentPortFacilityDtoList = new ArrayList<>();
        accidentPortFacilityDtoList.add(accidentPortFacilityDto);
        accidentPortFacilityDtoList.add(accidentPortFacilityDto2);

        Integer scenarioId = scenarioService.registerScenario(scenarioDto, accidentPortFacilityDtoList);
        Scenario scenario = scenarioRepository.findById(scenarioId).get();


        AccidentPortFacilityDto updateAccidentPortFacilityDto = AccidentPortFacilityDto.builder()
                .name("지게차")
                .scenario(scenario)
                .build();

        AccidentPortFacilityDto updateAccidentPortFacilityDto2 = AccidentPortFacilityDto.builder()
                .name("사다리")
                .scenario(scenario)
                .build();

        AccidentPortFacilityDto updateAccidentPortFacilityDto3 = AccidentPortFacilityDto.builder()
                .name("컨테이너")
                .scenario(scenario)
                .build();

        List<AccidentPortFacilityDto> updateAccidentPortFacilityDtoList = new ArrayList<>();
        updateAccidentPortFacilityDtoList.add(updateAccidentPortFacilityDto);
        updateAccidentPortFacilityDtoList.add(updateAccidentPortFacilityDto2);
        updateAccidentPortFacilityDtoList.add(updateAccidentPortFacilityDto3);

        //when
        Integer updateScenarioId = scenarioService.modifyAccidentPortFacility(updateAccidentPortFacilityDtoList);

        //then
        Scenario updateScenario = scenarioRepository.findById(updateScenarioId).get();
        List<AccidentPortFacility> updateAccidentPortFacilityList = updateScenario.getAccidentPortFacilityList();

        Assertions.assertEquals(updateAccidentPortFacilityDto.toEntity().getName(), updateAccidentPortFacilityList.get(0).getName());
        Assertions.assertEquals(updateAccidentPortFacilityDto2.toEntity().getName(), updateAccidentPortFacilityList.get(1).getName());
        Assertions.assertEquals(updateAccidentPortFacilityDto3.toEntity().getName(), updateAccidentPortFacilityList.get(2).getName());
        assertEquals(3, updateAccidentPortFacilityList.size());
        assertEquals(updateScenarioId, updateAccidentPortFacilityList.get(0).getScenario().getId());
        assertEquals(updateScenarioId, updateAccidentPortFacilityList.get(1).getScenario().getId());
    }

    @Test
    public void 시나리오_삭제() {
        //given
        ScenarioDto scenarioDto = ScenarioDto.builder()
                .name("SY2")
                .build();

        AccidentPortFacilityDto accidentPortFacilityDto = AccidentPortFacilityDto.builder()
                .name("크레인")
                .scenario(scenarioDto.toEntity())
                .build();

        AccidentPortFacilityDto accidentPortFacilityDto2 = AccidentPortFacilityDto.builder()
                .name("컨테이너")
                .scenario(scenarioDto.toEntity())
                .build();

        List<AccidentPortFacilityDto> accidentPortFacilityDtoList = new ArrayList<>();
        accidentPortFacilityDtoList.add(accidentPortFacilityDto);
        accidentPortFacilityDtoList.add(accidentPortFacilityDto2);

        Integer scenarioId = scenarioService.registerScenario(scenarioDto, accidentPortFacilityDtoList);

        //when
        scenarioService.deleteScenario(scenarioId);

        //then
        Optional<Scenario> deleteScenario = scenarioRepository.findById(scenarioId);
        assertFalse(deleteScenario.isPresent());
    }

}