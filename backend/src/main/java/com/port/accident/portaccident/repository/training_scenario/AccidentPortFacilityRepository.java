package com.port.accident.portaccident.repository.training_scenario;

import com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AccidentPortFacilityRepository extends JpaRepository<AccidentPortFacility, Integer> {
    @Override
    Optional<AccidentPortFacility> findById(Integer id);

    @Transactional
    @Modifying
    @Query("delete from AccidentPortFacility a where a.scenario.id = :scenarioId")
    void deleteByScenarioId(@Param("scenarioId") Integer scenarioId);

//    @Query("select a from AccidentPortFacility a where a.scenario = :scenario")
//    List<AccidentPortFacility> findByScenario(@Param("scenario") Scenario scenario);
}
