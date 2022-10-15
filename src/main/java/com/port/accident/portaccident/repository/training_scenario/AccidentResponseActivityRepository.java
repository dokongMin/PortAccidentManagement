package com.port.accident.portaccident.repository.training_scenario;

import com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentResponseActivityDetailDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentResponseActivityDto;
import com.port.accident.portaccident.enums.IncidentLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccidentResponseActivityRepository extends JpaRepository<AccidentResponseActivity, Integer> {
    @Override
    Optional<AccidentResponseActivity> findById(Integer id);

    @Query("select a from AccidentResponseActivity a where a.scenario.id = :scenarioId order by a.completePlaningTime asc")
    List<AccidentResponseActivity> findByScenarioId(@Param("scenarioId") Integer scenarioId);

}
