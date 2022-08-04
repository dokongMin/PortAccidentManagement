package com.port.accident.portaccident.repository.training_scenario_result;

import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainingResultRepository extends JpaRepository<TrainingResult, Integer> {
    Optional<TrainingResult> findByName(String name);

}
