package com.port.accident.portaccident.repository.training_scenario;

import com.port.accident.portaccident.dto.training_scenario.ScenarioAccidentResponseActivityDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScenarioRepositoryCustom {
    Page<ScenarioAccidentResponseActivityDto> searchPageScenario(ScenarioSearchCondition condition, Pageable pageable);
}
