package com.port.accident.portaccident.repository.training_scenario;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
//@Rollback(value = false)
@Transactional
public class ScenarioRepositoryTest {

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    AccidentPortFacilityRepository accidentPortFacilityRepository;

    @Test
    public void 시나리오_등록() {
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

        scenarioDto.addAccidentPortFacility(accidentPortFacilityDtoList);

        //when
        Scenario scenario = scenarioRepository.save(scenarioDto.toEntity());
        AccidentPortFacility accidentPortFacility = accidentPortFacilityRepository.save(accidentPortFacilityDto.toEntity());
        AccidentPortFacility accidentPortFacility2 = accidentPortFacilityRepository.save(accidentPortFacilityDto2.toEntity());


        //then
        assertEquals(scenarioDto.toEntity().getName(), scenario.getName());
        assertEquals(accidentPortFacilityDto.toEntity().getName(), accidentPortFacility.getName());
        assertEquals(accidentPortFacilityDto2.toEntity().getName(), accidentPortFacility2.getName());
        assertEquals(2, scenario.getAccidentPortFacilityList().size());
    }
}