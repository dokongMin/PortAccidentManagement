package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.code.DetailedCode;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.port.accident.portaccident.dto.code.DetailedCodeDto;
import com.port.accident.portaccident.dto.code.RepresentativeCodeDto;
import com.port.accident.portaccident.repository.code.DetailedCodeRepository;
import com.port.accident.portaccident.repository.code.RepresentativeCodeRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.port.accident.portaccident.exception.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
@Rollback(value = false)
public class CodeServiceTest {
    EntityManager em;

    @Autowired
    CodeService codeService;

    @Autowired
    RepresentativeCodeRepository representativeCodeRepository;

    @Autowired
    DetailedCodeRepository detailedCodeRepository;

    @Test
    public void duplicateCreateRepCodeTest() {
        //given
        RepresentativeCodeDto repCodeDto = RepresentativeCodeDto.builder()
                .code("AT01")
                .name("대표코드명")
                .build();

        RepresentativeCodeDto repCodeDto2 = RepresentativeCodeDto.builder()
                .code("AT01")
                .name("대표코드명")
                .build();

        //when
        codeService.createRepresentativeCode(repCodeDto.toEntity());
        try {
            codeService.createRepresentativeCode(repCodeDto2.toEntity());
        } catch (RuntimeException e) {
            //then
            Assertions.assertEquals("이미 존재하는 대표코드명입니다.", e.getMessage());
        }
    }

    @Test
    public void duplicateCreateDetCodeTest() {
        RepresentativeCode repCode = representativeCodeRepository.findByCode("AT01").get();
        DetailedCodeDto detCodeDto = DetailedCodeDto.builder()
                .code("AD01")
                .name("크레인")
                .comment("하물을 들어올려서 상하/좌우/전후로 운반하는 기계장치")
                .representativeCode(repCode)
                .build();

        DetailedCodeDto detCodeDto2 = DetailedCodeDto.builder()
                .code("AD01")
                .name("크레인")
                .comment("하물을 들어올려서 상하/좌우/전후로 운반하는 기계장치")
                .representativeCode(repCode)
                .build();

        //when
        codeService.createDetailedCode(detCodeDto.toEntity());
        try {
            codeService.createDetailedCode(detCodeDto2.toEntity());
        } catch (RuntimeException e) {
            //then
            Assertions.assertEquals("이미 존재하는 상세코드명입니다.", e.getMessage());
        }
    }

    @Test
    @Transactional
    public void updateReqCode(){
        //given
        Integer updateId = 1;
        String updateName = "변경된 대표코드명";

        //when
        codeService.updateRepresentativeCode(updateId,updateName);
        RepresentativeCode updateRepCode = representativeCodeRepository.findById(updateId).get();

        //then
        assertEquals(updateRepCode.getName(), "변경된 대표코드명");
    }



    @Test
    public void updateDetCode(){
        //given
        RepresentativeCodeDto repCodeDto = RepresentativeCodeDto.builder()
                .code("BT01")
                .name("추가된 대표코드명")
                .build();
        Integer repCodeId = codeService.createRepresentativeCode(repCodeDto.toEntity());
        RepresentativeCode repCode = representativeCodeRepository.findById(repCodeId).get();

        DetailedCodeDto dto = DetailedCodeDto.builder()
                .id(1)
                .code("BT01")
                .name("무역항 수상구역")
                .comment("외국 무역선이 출입하고, 무역화물이 취급되는 항만")
                .representativeCode(repCode)
                .build();

        //when
        Integer updateDetCodeId = codeService.updateDetailedCode(dto);
        DetailedCode updateDetCode = detailedCodeRepository.findById(updateDetCodeId).get();

        //then
        assertEquals(updateDetCode.getName(), "무역항 수상구역");
        assertEquals(updateDetCode.getRepresentativeCode().getCode(), "BT01");
        for (DetailedCode detailedCode : updateDetCode.getRepresentativeCode().getDetailedCode()) {
            System.out.println("detCode : "+detailedCode.getCode());
        }

    }
}