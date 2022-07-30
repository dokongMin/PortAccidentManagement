package com.port.accident.portaccident.repository.training_scenario;

import com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccidentPortFacilityRepository extends JpaRepository<AccidentPortFacility, Integer> {
    @Override
    Optional<AccidentPortFacility> findById(Integer integer);
}
