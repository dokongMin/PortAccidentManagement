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


@SpringBootTest
@RunWith(SpringRunner.class)
@Rollback(value = false)
public class CodeServiceTest {
    @Autowired
    CodeService codeService;

    @Autowired
    RepresentativeCodeRepository representativeCodeRepository;

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
}