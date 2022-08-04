package com.port.accident.portaccident.repository.training_scenario_result;

import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultCondition;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultDto;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultJoinScenarioDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrainingResultRepositoryCustom {
    Page<TrainingResultJoinScenarioDto> searchPageTrainingResults(TrainingResultCondition condition, Pageable pageable);

}
