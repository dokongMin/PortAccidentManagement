package com.port.accident.portaccident.service;


import com.port.accident.portaccident.dto.accident_management.type.AccidentTypeDto;
import com.port.accident.portaccident.dto.accident_management.type.DisasterTypeDto;
import com.port.accident.portaccident.exception.DuplicateAccidentTypeException;
import com.port.accident.portaccident.exception.DuplicateDisasterTypeException;
import com.port.accident.portaccident.repository.accidentManagement.AccidentTypeRepository;
import com.port.accident.portaccident.repository.accidentManagement.DisasterTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccidentTypeService {


    private final AccidentTypeRepository accidentTypeRepository;
    private final DisasterTypeRepository disasterTypeRepository;

    @Transactional
    public Integer saveAccidentType(AccidentTypeDto accidentTypeDto) {
        if (accidentTypeRepository.findByName(accidentTypeDto.getName()).isPresent()) {
            throw new DuplicateAccidentTypeException("이미 존재하는 사고 유형 입니다.");
        } else
            return accidentTypeRepository.save(accidentTypeDto.toEntity()).getId();
    }

    @Transactional
    public Integer saveDisasterType(DisasterTypeDto disasterTypeDto) {
        if (disasterTypeRepository.findByName(disasterTypeDto.getName()).isPresent()) {
            throw new DuplicateDisasterTypeException("이미 존재하는 사고 유형 입니다.");
        } else
            return disasterTypeRepository.save(disasterTypeDto.toEntity()).getId();
    }

}
