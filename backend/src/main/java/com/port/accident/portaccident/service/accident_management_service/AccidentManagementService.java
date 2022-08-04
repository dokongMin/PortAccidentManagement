package com.port.accident.portaccident.service.accident_management_service;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.dto.accident_management.AccidentInfoDto;

import com.port.accident.portaccident.repository.accident_management.AccidentManagementRepository;
import com.port.accident.portaccident.repository.accident_management.DisasterManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccidentManagementService {


    private final AccidentManagementRepository accidentManagementRepository;

    private final DisasterManagementRepository disasterManagementRepository;

    /**
     * 사고
     */
    @Transactional
    public Integer saveAccidentInfo(AccidentInfoDto accidentInfoDto) {
        return accidentManagementRepository.save(accidentInfoDto.toEntity()).getId();
    }

    public List<AccidentInfo> findAll(){
        return accidentManagementRepository.findAll();
    }

    /**
     * 재난
     */

    @Transactional
    public Integer saveDisasterInfo(AccidentInfoDto accidentInfoDto){
        return disasterManagementRepository.save(accidentInfoDto.toEntity()).getId();
    }
}


