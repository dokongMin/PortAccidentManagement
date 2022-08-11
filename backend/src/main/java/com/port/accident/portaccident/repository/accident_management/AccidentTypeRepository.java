package com.port.accident.portaccident.repository.accident_management;

import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccidentTypeRepository extends JpaRepository<AccidentType, Integer> {

    Optional<AccidentType> findByName(String name);

}
