package com.port.accident.portaccident.runner;

import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.port.accident.portaccident.dto.code.DetailedCodeDto;
import com.port.accident.portaccident.dto.code.RepresentativeCodeDto;
import com.port.accident.portaccident.repository.code.DetailedCodeRepository;
import com.port.accident.portaccident.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.Queue;

@Profile("local")
@Component
public class CodeRunner implements org.springframework.boot.ApplicationRunner {

    @Autowired
    CodeService codeService;

    @Autowired
    DetailedCodeRepository detailedCodeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Queue<RepresentativeCodeDto> repDtoQueue = new LinkedList<>();
        Queue<DetailedCodeDto> detDtoQueue = new LinkedList<>();

        //when
        createRepCodes(repDtoQueue);
        createDetCodes(detDtoQueue);
    }

    private void createRepCodes(Queue<RepresentativeCodeDto> repDtoQueue) {
        for (int i = 1; i <= 100; i++) {
            repDtoQueue.add(RepresentativeCodeDto.builder()
                    .code("AT" + i)
                    .name("대표코드" + i)
                    .build());
            RepresentativeCodeDto poll = repDtoQueue.poll();
            codeService.createRepresentativeCode(poll.toEntity());
        }
    }

    private void createDetCodes(Queue<DetailedCodeDto> detDtoQueue) {
        for (int i = 1; i <= 100; i++) {
            RepresentativeCode repCode = null;
            if (i < 50) {
                repCode = codeService.findByRepCode("AT10");
            } else {
                repCode = codeService.findByRepCode("AT20");
            }
            detDtoQueue.add(DetailedCodeDto.builder()
                    .code("AD" + i)
                    .name("상세코드" + i)
                    .comment("설명" + i)
                    .representativeCode(repCode)
                    .build());
            DetailedCodeDto poll = detDtoQueue.poll();

            detailedCodeRepository.save(poll.toEntity());

        }

    }


}
