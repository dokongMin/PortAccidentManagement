package com.port.accident.portaccident.repository.accident_management;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface DisasterManagementRepository extends JpaRepository<AccidentInfo, Integer> {


}
