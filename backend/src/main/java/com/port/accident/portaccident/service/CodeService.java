package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.code.DetailedCode;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.port.accident.portaccident.dto.code.DetailedCodeDto;
import com.port.accident.portaccident.dto.code.RepresentativeCodeDto;
import com.port.accident.portaccident.repository.code.DetailedCodeRepository;
import com.port.accident.portaccident.repository.code.RepresentativeCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.port.accident.portaccident.exception.*;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class CodeService {

    @Autowired
    DetailedCodeRepository detailedRepository;

    @Autowired
    RepresentativeCodeRepository representRepository;


    public List<DetailedCode> getDetailedCodeList() {
        return detailedRepository.findAll();
    }

    public List<RepresentativeCode> getRepresentativeCodeList() {
        return representRepository.findAll();
    }

    public Integer createRepresentativeCode(RepresentativeCode code) {
        if (representRepository.findByCode(code.getCode()).isPresent()) {
            throw new DuplicateCreateCodeException("이미 존재하는 대표코드명입니다.");
        } else {
            RepresentativeCode savedCode = representRepository.save(code);
            return savedCode.getId();
        }
    }

    public Integer createDetailedCode(DetailedCode code) {
        //싱세코드명 조회
        if (detailedRepository.findByCode(code.getCode()).isPresent()) {
            throw new DuplicateCreateCodeException("이미 존재하는 상세코드명입니다.");
        } else {
            updateRepCodeDetailList(code);
            DetailedCode savedCode = detailedRepository.save(code);
            return savedCode.getId();
        }
    }

    private void updateRepCodeDetailList(DetailedCode code) {
        RepresentativeCode representativeCode = representRepository.findByCode(code.getRepresentativeCode().getCode())
                .orElseThrow(() -> new DoesNotExistException());
        representativeCode.setDetailedCode(code);
    }

    public Integer updateRepresentativeCode(RepresentativeCodeDto dto) {
        RepresentativeCode code = representRepository.findByCode(dto.getCode()).orElseThrow(() -> new DoesNotExistException());
        code.updateRepCode(dto);
        return code.getId();
    }

    public Integer updateDetailedCode(DetailedCodeDto dto) {
        DetailedCode code = detailedRepository.findByCode(dto.getCode()).orElseThrow(() -> new DoesNotExistException());
        code.updateDetCode(dto);
        return code.getId();
    }
}
