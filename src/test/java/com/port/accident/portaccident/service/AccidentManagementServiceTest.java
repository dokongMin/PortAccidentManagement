package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import com.port.accident.portaccident.dto.accident_management.AccidentInfoDto;
import com.port.accident.portaccident.dto.accident_management.type.AccidentTypeDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccidentManagementServiceTest {

    private AccidentManagementService accidentManagementService;
    private AccidentTypeService accidentTypeService;

    @Test
    public void 사고등록() throws Exception {
        // given
        AccidentTypeDto typeDto = AccidentTypeDto.builder()
                .name("추락")
                .build();
        accidentTypeService.saveAccidentType(typeDto);

        AccidentInfoDto.builder()
                .accidentDate(LocalDateTime.now())
                .accidentArea("연안항")
                .accidentLevel("Level 1")
                .accidentImpact("경상")
                .accidentManager("정민환")
                .victim("희생자1")
                .accidentTypeList((List<AccidentType>) typeDto)
                .causesSafetyAccidentList()
                .damageFacilityList()

        // when

        // then

    }

}