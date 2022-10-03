package com.port.accident.portaccident.repository.code;

import com.port.accident.portaccident.domain.code.DetailedCode;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetailedCodeRepository extends JpaRepository<DetailedCode, Integer>,CodeRepositoryCustom {
    Optional<DetailedCode> findByCode(String code);

}
