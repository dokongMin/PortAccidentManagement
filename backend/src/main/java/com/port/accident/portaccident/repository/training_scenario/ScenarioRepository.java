package com.port.accident.portaccident.repository.training_scenario;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.dto.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ScenarioRepository extends JpaRepository<Scenario, Integer>, ScenarioRepositoryCustom {
    @Query("select s from Scenario s where s.name = :name")
    Optional<Scenario> findByName(@Param("name") String name);

    @Override
    Optional<Scenario> findById(Integer integer);
}
