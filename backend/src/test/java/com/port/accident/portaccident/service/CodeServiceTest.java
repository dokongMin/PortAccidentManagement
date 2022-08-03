package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.code.DetailedCode;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.port.accident.portaccident.dto.code.CodeSearchCondition;
import com.port.accident.portaccident.dto.code.DetRepJoinDto;
import com.port.accident.portaccident.dto.code.DetailedCodeDto;
import com.port.accident.portaccident.dto.code.RepresentativeCodeDto;
import com.port.accident.portaccident.repository.code.DetailedCodeRepository;
import com.port.accident.portaccident.repository.code.RepresentativeCodeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.port.accident.portaccident.exception.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class CodeServiceTest {
    EntityManager em;

    @Autowired
    CodeService codeService;

    @Autowired
    RepresentativeCodeRepository representativeCodeRepository;

    @Autowired
    DetailedCodeRepository detailedCodeRepository;

    @Before
    public void setup(){
        RepresentativeCodeDto repCodeDto1 = RepresentativeCodeDto.builder()
                .code("AT01")
                .name("대표코드1")
                .build();
        RepresentativeCodeDto repCodeDto2 = RepresentativeCodeDto.builder()
                .code("AT02")
                .name("대표코드2")
                .build();
        RepresentativeCodeDto repCodeDto3 = RepresentativeCodeDto.builder()
                .code("AT03")
                .name("대표코드3")
                .build();

        RepresentativeCode repCode = representativeCodeRepository.save(repCodeDto1.toEntity());
        representativeCodeRepository.save(repCodeDto2.toEntity());
        representativeCodeRepository.save(repCodeDto3.toEntity());

        DetailedCodeDto detCodeDto1 = DetailedCodeDto.builder()
                .code("AD01")
                .name("상세코드1")
                .comment("설명1")
                .representativeCode(repCode)
                .build();
        DetailedCodeDto detCodeDto2 = DetailedCodeDto.builder()
                .code("AD02")
                .name("상세코드2")
                .comment("설명2")
                .representativeCode(repCode)
                .build();
        DetailedCodeDto detCodeDto3 = DetailedCodeDto.builder()
                .code("AD03")
                .name("상세코드3")
                .comment("설명3")
                .representativeCode(repCode)
                .build();

        //when
        detailedCodeRepository.save(detCodeDto1.toEntity());
        detailedCodeRepository.save(detCodeDto2.toEntity());
        detailedCodeRepository.save(detCodeDto3.toEntity());
    }

    @Test
    public void duplicateCreateRepCodeTest() {
        //given
        RepresentativeCodeDto repCodeDto = RepresentativeCodeDto.builder()
                .code("AT01")
                .name("대표코드명")
                .build();

        //when
        try {
            codeService.createRepresentativeCode(repCodeDto.toEntity());
        } catch (RuntimeException e) {
            //then
            Assertions.assertEquals("이미 존재하는 대표코드명입니다.", e.getMessage());
        }
    }

    @Test
    public void duplicateCreateDetCodeTest() {
        DetailedCodeDto detCodeDto = DetailedCodeDto.builder()
                .code("AD01")
                .name("크레인")
                .comment("하물을 들어올려서 상하/좌우/전후로 운반하는 기계장치")
                .build();

        //when
        try {
            codeService.createDetailedCode(detCodeDto.toEntity(),1);
        } catch (RuntimeException e) {
            //then
            Assertions.assertEquals("이미 존재하는 상세코드명입니다.", e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void updateReqCode(){
        //given
        Integer findRepCodeId = 1;
        String updateName = "변경된 대표코드명";

        //when
        codeService.updateRepresentativeCode(findRepCodeId,updateName);
        RepresentativeCode updateRepCode = representativeCodeRepository.findById(findRepCodeId).get();

        //then
        assertEquals(updateRepCode.getName(), "변경된 대표코드명");
    }



    @Test
    @Transactional
    @Rollback(value = false)
    public void updateDetCode(){
        //given
        Integer repCodeId = 2;  //대표코드를 1에서 2로 변경
        RepresentativeCode repCode = representativeCodeRepository.findById(2).get();

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

    @Test
    public void searchRetCodeWithPagingTest(){
        CodeSearchCondition condition = new CodeSearchCondition();
        PageRequest pageRequest = PageRequest.of(0,2);  //0페이지부터 시작해서 3개씩 가져옴
        Page<RepresentativeCode> result = codeService.searchRepCodeListWithPaging(condition, pageRequest);
        assertEquals(result.getSize(),2);
        assertEquals(result.getContent().get(0).getCode(),"AT01");
        assertEquals(result.getContent().get(1).getCode(),"AT02");

    }

    @Test
    public void searchDetCodeWithPagingTest(){
        CodeSearchCondition condition = new CodeSearchCondition();
        PageRequest pageRequest = PageRequest.of(0,2);  //0페이지부터 시작해서 3개씩 가져옴
        Page<DetRepJoinDto> result = codeService.searchDetCodeListWithPaging(condition, pageRequest);
        assertEquals(result.getSize(),2);
        assertEquals(result.getContent().get(0).getDetCode(),"AD01");
        assertEquals(result.getContent().get(1).getDetCode(),"AD02");

    }

}