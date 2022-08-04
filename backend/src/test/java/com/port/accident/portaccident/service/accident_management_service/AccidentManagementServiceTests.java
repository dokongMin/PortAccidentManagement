package com.port.accident.portaccident.service.accident_management_service;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccident;
import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacility;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo;
import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import com.port.accident.portaccident.dto.accident_management.AccidentInfoDto;
import com.port.accident.portaccident.dto.accident_management.elements.CausesSafetyAccidentDto;
import com.port.accident.portaccident.dto.accident_management.elements.CausesSafetyAccidentInfoDto;
import com.port.accident.portaccident.dto.accident_management.elements.DamageFacilityDto;
import com.port.accident.portaccident.dto.accident_management.elements.DamageFacilityInfoDto;
import com.port.accident.portaccident.dto.accident_management.type.AccidentTypeDto;
import com.port.accident.portaccident.repository.accident_management.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class AccidentManagementServiceTests {

    @Autowired
    private AccidentManagementService accidentManagementService;
    @Autowired
    private AccidentManagementRepository accidentManagementRepository;
    @Autowired
    private AccidentTypeService accidentTypeService;
    @Autowired
    private AccidentTypeRepository accidentTypeRepository;
    @Autowired
    private CausesSafetyAccidentService causesSafetyAccidentService;
    @Autowired
    private CausesSafetyAccidentRepository causesSafetyAccidentRepository;
    @Autowired
    private CausesSafetyAccidentInfoRepository causesSafetyAccidentInfoRepository;
    @Autowired
    private DamageFacilityService damageFacilityService;
    @Autowired
    private DamageFacilityRepository damageFacilityRepository;
    @Autowired
    private DamageFacilityInfoRepository damageFacilityInfoRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void 사고등록() throws Exception {
        // given
        /**
         * Accident Type 저장
         */
        AccidentTypeDto typeDto = AccidentTypeDto.builder()
                .name("추락")
                .build();
        Integer typeId = accidentTypeService.saveAccidentType(typeDto);
        AccidentType accidentType = accidentTypeRepository.findByName("추락").orElseThrow(() -> new Exception("해당 사고유형은 존재하지 않습니다."));

        /**
         * CausesSafety 저장
         */
        CausesSafetyAccidentDto causesDto1 = CausesSafetyAccidentDto.builder()
                .name("안전관리 소홀")
                .build();
        Integer causesId1 = causesSafetyAccidentService.saveCausesSafetyAccident(causesDto1);
        CausesSafetyAccident causesSafetyAccident = causesSafetyAccidentRepository.findById(causesId1).get();

        CausesSafetyAccidentDto causesDto2 = CausesSafetyAccidentDto.builder()
                .name("부주의")
                .build();
        Integer causesId2 = causesSafetyAccidentService.saveCausesSafetyAccident(causesDto1);
        CausesSafetyAccident causesSafetyAccident2 = causesSafetyAccidentRepository.findById(causesId2).get();
        List<CausesSafetyAccidentInfo> causesSafetyAccidentInfoList = causesSafetyAccident.getCausesSafetyAccidentInfoList();
        /**
         * DamageFacility 저장
         */
        DamageFacilityDto facility = DamageFacilityDto.builder()
                .name("크레인")
                .build();
        Integer facilityId = damageFacilityService.saveDamageFacility(facility);
        DamageFacility damageFacility = damageFacilityRepository.findById(facilityId).get();

        /**
         * AccidentInfo 저장
         */
        AccidentInfoDto accidentInfoDto = AccidentInfoDto.builder()
                .accidentDate(LocalDateTime.now())
                .accidentArea("연안항")
                .accidentLevel("Level 1")
                .accidentImpact("경상")
                .accidentManager("정민환")
                .victim("희생자1")
                .accidentType(accidentType)
//                .causesSafetyAccidentInfoList()
//                .damageFacilityList()
                .build();
        Integer accidentId = accidentManagementService.saveAccidentInfo(accidentInfoDto);
        AccidentInfo accidentInfo = accidentManagementRepository.findById(accidentId).get();

        /**
         * CausesSafetyInfo 저장 -> 다대다 연관관계 분리 테이블
         */
        CausesSafetyAccidentInfoDto causesSafetyAccidentInfoDto = CausesSafetyAccidentInfoDto.builder()
                .accidentInfo(accidentInfo)
                .causesSafetyAccident(causesSafetyAccident)
                .build();
        Integer causesSafetyAccidentInfoId = causesSafetyAccidentService.saveCausesSafetyAccidentInfo(causesSafetyAccidentInfoDto);
        CausesSafetyAccidentInfo causesSafetyAccidentInfo = causesSafetyAccidentInfoRepository.findById(causesSafetyAccidentInfoId).get();

        /**
         * DamageFacilityInfo 저장 -> 다대다 연관관계 분리 테이블
         */
        DamageFacilityInfoDto damageFacilityInfoDto = DamageFacilityInfoDto.builder()
                .accidentInfo(accidentInfo)
                .damageFacility(damageFacility)
                .build();
        Integer damageFacilityInfoId = damageFacilityService.saveDamageFacilityInfo(damageFacilityInfoDto);
        DamageFacilityInfo damageFacilityInfo = damageFacilityInfoRepository.findById(damageFacilityInfoId).get();
        // when

        // then

    }
}