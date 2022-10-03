package com.port.accident.portaccident.repository.accident_management;

import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import com.port.accident.portaccident.domain.accident_management.type.DisasterType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisasterTypeRepository extends JpaRepository<DisasterType, Integer> {

    Optional<DisasterType> findByName(String name);
}
