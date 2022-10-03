package com.port.accident.portaccident.service.accident_management_service;

import com.port.accident.portaccident.dto.accident_management.elements.CausesSafetyAccidentInfoDto;

import com.port.accident.portaccident.repository.accident_management.CausesSafetyAccidentInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CausesSafetyAccidentService {

//    private final CausesSafetyAccidentRepository causesSafetyAccidentRepository;
    private final CausesSafetyAccidentInfoRepository causesSafetyAccidentInfoRepository;


//    @Transactional
//    public Integer saveCausesSafetyAccident(CausesSafetyAccidentDto causesSafetyAccidentDto){
////        if (causesSafetyAccidentRepository.findByName(causesSafetyAccidentDto.getName()).isPresent()) {
////            throw new DuplicateAccidentTypeException("이미 존재하는 사고 발생 원인 입니다.");
////        } else
//            return causesSafetyAccidentRepository.save(causesSafetyAccidentDto.toEntity()).getId();
//    }

    @Transactional
    public Integer saveCausesSafetyAccidentInfo(CausesSafetyAccidentInfoDto causesSafetyAccidentInfoDto){
            return causesSafetyAccidentInfoRepository.save(causesSafetyAccidentInfoDto.toEntity()).getId();
    }
}
