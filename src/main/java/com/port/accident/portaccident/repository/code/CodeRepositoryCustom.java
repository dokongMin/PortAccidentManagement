package com.port.accident.portaccident.repository.code;

import com.port.accident.portaccident.domain.code.DetailedCode;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.port.accident.portaccident.dto.code.CodeSearchCondition;
import com.port.accident.portaccident.dto.code.DetRepJoinDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CodeRepositoryCustom {
    Page<RepresentativeCode> searchPageRepCode(CodeSearchCondition condition, Pageable pageable);
    Page<DetRepJoinDto> searchPageDetCode(CodeSearchCondition condition, Pageable pageable);
}
