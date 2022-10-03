package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.code.DetailedCode;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.port.accident.portaccident.dto.code.CodeSearchCondition;
import com.port.accident.portaccident.dto.code.DetRepJoinDto;
import com.port.accident.portaccident.dto.code.DetailedCodeDto;
import com.port.accident.portaccident.dto.code.RepresentativeCodeDto;
import com.port.accident.portaccident.repository.code.DetailedCodeRepository;
import com.port.accident.portaccident.repository.code.RepresentativeCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.port.accident.portaccident.exception.*;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CodeService {

    private final DetailedCodeRepository detailedRepository;

    private final RepresentativeCodeRepository representRepository;

    public RepresentativeCode findByRepCode(String code) {
        Optional<RepresentativeCode> byCode = representRepository.findByCode(code);
        return byCode.orElseThrow(() -> new DoesNotExistException());
    }

    public RepresentativeCode findByRepCodeId(Integer id) {
        Optional<RepresentativeCode> byId = representRepository.findById(id);
        return byId.orElseThrow(() -> new DoesNotExistException());
    }

    public DetailedCode findByDetCode(String code) {
        Optional<DetailedCode> byCode = detailedRepository.findByCode(code);
        return byCode.orElseThrow(() -> new DoesNotExistException());
    }

    public DetailedCode findByDetCodeId(Integer id) {
        Optional<DetailedCode> byId = detailedRepository.findById(id);
        return byId.orElseThrow(() -> new DoesNotExistException());

    }

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

    @Transactional
    public Integer createDetailedCode(DetailedCode code, Integer repCodeId) {
        if (detailedRepository.findByCode(code.getCode()).isPresent()) {
            throw new DuplicateCreateCodeException("이미 존재하는 상세코드명입니다.");
        } else {
            Optional<RepresentativeCode> repCode = representRepository.findById(repCodeId);
            if (repCode.isPresent()) {
                code.setRepresentativeCode(repCode.get());
                DetailedCode savedCode = detailedRepository.save(code);
                return savedCode.getId();
            }
            throw new CanNotCreateEntityException();
        }
    }

    @Transactional
    public void updateRepresentativeCode(Integer id, String name) {
        Optional<RepresentativeCode> repCode = representRepository.findById(id);
        repCode.orElseThrow(() -> new DoesNotExistException());
        RepresentativeCode transRepCode = repCode.get();
        transRepCode.setName(name);
    }

    @Transactional
    public Integer updateDetailedCode(DetailedCodeDto dto) {
        DetailedCode code = detailedRepository.findById(dto.getId()).orElseThrow(() -> new DoesNotExistException());
        code.updateDetCode(dto);
        return code.getId();
    }

    @Transactional(readOnly = true)
    public Page<RepresentativeCode> searchRepCodeListWithPaging(CodeSearchCondition condition, Pageable pageable) {
        return representRepository.searchPageRepCode(condition, pageable);
    }

    @Transactional(readOnly = true)
    public Page<DetRepJoinDto> searchDetCodeListWithPaging(CodeSearchCondition condition, Pageable pageable) {
        return detailedRepository.searchPageDetCode(condition, pageable);
    }

}
