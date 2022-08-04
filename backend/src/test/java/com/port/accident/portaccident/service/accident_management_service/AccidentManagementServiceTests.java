package com.port.accident.portaccident.service.accident_management_service;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentEnum;
import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityEnum;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo;
import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import com.port.accident.portaccident.domain.accident_management.type.AccidentTypeEnum;
import com.port.accident.portaccident.dto.accident_management.AccidentInfoDto;
import com.port.accident.portaccident.dto.accident_management.elements.CausesSafetyAccidentInfoDto;
import com.port.accident.portaccident.dto.accident_management.elements.DamageFacilityInfoDto;
import com.port.accident.portaccident.dto.accident_management.type.AccidentTypeDto;
import com.port.accident.portaccident.repository.accident_management.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private CausesSafetyAccidentInfoRepository causesSafetyAccidentInfoRepository;
    @Autowired
    private DamageFacilityService damageFacilityService;

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
                .name(AccidentTypeEnum.FallDown.getValue())
                .build();
        Integer typeId = accidentTypeService.saveAccidentType(typeDto);
        AccidentType accidentType = accidentTypeRepository.findById(typeId).get();


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
//                .causesSafetyAccidentInfoList(causesSafetyAccidentInfoList)
//                .damageFacilityInfoList(damageFacilityInfoList)
                .build();
        Integer accidentId = accidentManagementService.saveAccidentInfo(accidentInfoDto);
        AccidentInfo accidentInfo = accidentManagementRepository.findById(accidentId).get();

        /**
         * CausesSafetyInfo 저장 -> 다대다 연관관계 분리 테이블
         */

        CausesSafetyAccidentInfoDto causesSafetyAccidentInfoDto = CausesSafetyAccidentInfoDto.builder()
                .name(CausesSafetyAccidentEnum.Carelessness.getValue())
                .accidentInfo(accidentInfo)
                .causesSafetyAccidentEnum(CausesSafetyAccidentEnum.Carelessness)
                .build();
        Integer causesSafetyAccidentInfoId = causesSafetyAccidentService.saveCausesSafetyAccidentInfo(causesSafetyAccidentInfoDto);
        CausesSafetyAccidentInfo cause1 = causesSafetyAccidentInfoRepository.findById(causesSafetyAccidentInfoId).get();

        CausesSafetyAccidentInfoDto causesSafetyAccidentInfoDto2 = CausesSafetyAccidentInfoDto.builder()
                .name(CausesSafetyAccidentEnum.WeakFacility.getValue())
                .accidentInfo(accidentInfo)
                .causesSafetyAccidentEnum(CausesSafetyAccidentEnum.WeakFacility)
                .build();
        Integer causesSafetyAccidentInfoId2 = causesSafetyAccidentService.saveCausesSafetyAccidentInfo(causesSafetyAccidentInfoDto2);
        CausesSafetyAccidentInfo cause2 = causesSafetyAccidentInfoRepository.findById(causesSafetyAccidentInfoId2).get();

        List<CausesSafetyAccidentInfo> causesSafetyAccidentInfoList = new ArrayList<>();
        causesSafetyAccidentInfoList.add(cause1);
        causesSafetyAccidentInfoList.add(cause2);

        /**
         * DamageFacilityInfo 저장 -> 다대다 연관관계 분리 테이블
         */
        DamageFacilityInfoDto damageFacilityInfoDto = DamageFacilityInfoDto.builder()
                .name(DamageFacilityEnum.Container.getValue())
                .accidentInfo(accidentInfo)
                .damageFacilityEnum(DamageFacilityEnum.Container)
                .build();
        Integer damageFacilityInfoId = damageFacilityService.saveDamageFacilityInfo(damageFacilityInfoDto);
        DamageFacilityInfo damage1 = damageFacilityInfoRepository.findById(damageFacilityInfoId).get();

        DamageFacilityInfoDto damageFacilityInfoDto2 = DamageFacilityInfoDto.builder()
                .name(DamageFacilityEnum.Crane.getValue())
                .accidentInfo(accidentInfo)
                .damageFacilityEnum(DamageFacilityEnum.Crane)
                .build();
        Integer damageFacilityInfoId2 = damageFacilityService.saveDamageFacilityInfo(damageFacilityInfoDto2);
        DamageFacilityInfo damage2 = damageFacilityInfoRepository.findById(damageFacilityInfoId2).get();
        
        List<DamageFacilityInfo> damageFacilityInfoList = new ArrayList<>();
        damageFacilityInfoList.add(damage1);
        damageFacilityInfoList.add(damage2);


        // then
        Assertions.assertThat(accidentInfoDto.getAccidentManager()).isEqualTo("정민환");
        Assertions.assertThat(causesSafetyAccidentInfoDto.getAccidentInfo().getAccidentType().getName()).isEqualTo("추락");
        Assertions.assertThat(causesSafetyAccidentInfoDto.getAccidentInfo().getAccidentManager()).isEqualTo("정민환");
    }

    @Transactional
    @Rollback(value = false)
    @Test
    public void 사고수정 () throws Exception{
        // given
        /**
         * Accident Type 저장
         */
        AccidentTypeDto typeDto = AccidentTypeDto.builder()
                .name(AccidentTypeEnum.FallDown.getValue())
                .build();
        Integer typeId = accidentTypeService.saveAccidentType(typeDto);
        AccidentType accidentType = accidentTypeRepository.findById(typeId).get();


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
                .build();
        Integer accidentId = accidentManagementService.saveAccidentInfo(accidentInfoDto);

        AccidentInfoDto accidentInfoDto2 = AccidentInfoDto.builder()
                .accidentDate(LocalDateTime.now())
                .accidentArea("무역항")
                .accidentLevel("Level 2")
                .accidentImpact("중상")
                .accidentManager("초코쿠키")
                .victim("희생자2")
                .accidentType(accidentType)
                .build();

        // when
        accidentManagementService.update(accidentId, accidentInfoDto2);
        // then
        AccidentInfo accidentInfo = accidentManagementRepository.findById(accidentId).get();
        Assertions.assertThat(accidentInfo.getAccidentManager()).isEqualTo("초코쿠키");
     }
}