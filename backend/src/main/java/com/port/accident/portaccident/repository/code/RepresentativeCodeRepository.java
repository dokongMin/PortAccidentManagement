package com.port.accident.portaccident.repository.code;

import com.port.accident.portaccident.domain.code.RepresentativeCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepresentativeCodeRepository extends JpaRepository<RepresentativeCode, Integer> ,CodeRepositoryCustom{
    Optional<RepresentativeCode> findByCode(String code);
}
