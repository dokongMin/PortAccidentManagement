package com.port.accident.portaccident.repository.training_scenario;

import com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccidentPortFacilityRepository extends JpaRepository<AccidentPortFacility, Integer> {
    @Override
    Optional<AccidentPortFacility> findById(Integer id);

    @Query("select a from AccidentPortFacility a where a.scenario.id = :scenarioId")
    List<AccidentPortFacility> findByScenarioId(@Param("scenarioId") Integer scenarioId);
}
