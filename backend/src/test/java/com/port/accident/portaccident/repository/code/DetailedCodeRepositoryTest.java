package com.port.accident.portaccident.repository.code;

import com.port.accident.portaccident.domain.code.DetailedCode;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.port.accident.portaccident.dto.code.DetailedCodeDto;
import com.port.accident.portaccident.dto.code.RepresentativeCodeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Rollback(value = false)
public class DetailedCodeRepositoryTest {

    @Autowired
    RepresentativeCodeRepository representativeCodeRepository;

    @Autowired
    DetailedCodeRepository detailedCodeRepository;

    @Test
    public void create_representativeCode(){
        //given
        RepresentativeCodeDto codeDto = RepresentativeCodeDto.builder()
                .code("AT01")
                .name("대표코드명")
                .build();

        //when
        RepresentativeCode savedCode = representativeCodeRepository.save(codeDto.toEntity());

        //then
        assertEquals(savedCode.getCode(), "AT01");
    }

    @Test
    public void create_detailedCode(){
        //given
        RepresentativeCode repCode = representativeCodeRepository.findByCode("AT01").get();
        DetailedCodeDto codeDto = DetailedCodeDto.builder()
                .code("AD01")
                .name("크레인")
                .comment("하물을 들어올려서 상하/좌우/전후로 운반하는 기계장치")
                .representativeCode(repCode)
                .build();

        //when
        DetailedCode savedCode = detailedCodeRepository.save(codeDto.toEntity());

        //then
        assertEquals(savedCode.getCode(), "AD01");
        assertEquals(savedCode.getRepresentativeCode().getCode(), "AT01");

    }
}