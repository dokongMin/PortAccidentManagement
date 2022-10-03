package com.port.accident.portaccident.repository.accident_management;

import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CausesSafetyAccidentInfoRepository extends JpaRepository<CausesSafetyAccidentInfo, Integer> {

    Optional<CausesSafetyAccidentInfo> findById(Integer Id);
    Optional<CausesSafetyAccidentInfo> findByName(String name);
}
