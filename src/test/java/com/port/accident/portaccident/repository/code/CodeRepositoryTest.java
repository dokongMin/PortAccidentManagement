package com.port.accident.portaccident.repository.code;

import com.port.accident.portaccident.domain.code.DetailedCode;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.port.accident.portaccident.dto.code.CodeSearchCondition;
import com.port.accident.portaccident.dto.code.DetRepJoinDto;
import com.port.accident.portaccident.dto.code.DetailedCodeDto;
import com.port.accident.portaccident.dto.code.RepresentativeCodeDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Rollback(value = false)
public class CodeRepositoryTest {

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

    @Test
    public void searchPageRepCode(){
        CodeSearchCondition condition = new CodeSearchCondition();
        PageRequest pageRequest = PageRequest.of(0,2);  //0페이지부터 시작해서 3개씩 가져옴
        Page<RepresentativeCode> result = representativeCodeRepository.searchPageRepCode(condition, pageRequest);
        assertEquals(result.getSize(),2);
        assertEquals(result.getContent().get(0).getCode(),"AT01");
        assertEquals(result.getContent().get(1).getCode(),"AT02");

    }

    @Test
    public void searchPageDetCode(){
        CodeSearchCondition condition = new CodeSearchCondition();
        PageRequest pageRequest = PageRequest.of(0,2);  //0페이지부터 시작해서 3개씩 가져옴
        Page<DetRepJoinDto> result = detailedCodeRepository.searchPageDetCode(condition, pageRequest);

        assertEquals(result.getSize(),2);
        assertEquals(result.getContent().get(0).getDetCode(),"AD01");
        assertEquals(result.getContent().get(1).getDetCode(),"AD02");

    }
}