package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
import com.port.accident.portaccident.repository.training_scenario.AccidentPortFacilityRepository;
import com.port.accident.portaccident.repository.training_scenario.ScenarioRepository;
import com.port.accident.portaccident.repository.training_scenario.ScenarioRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ScenarioService {
    private final ScenarioRepository scenarioRepository;
    private final ScenarioRepositoryCustom scenarioRepositoryCustom;
    private final AccidentPortFacilityRepository accidentPortFacilityRepository;

    @Transactional
    public Integer saveScenario(ScenarioDto scenarioDto) {
        validateDuplicateScenario(scenarioDto); // 중복 시나리오 검증

        return scenarioRepository.save(scenarioDto.toEntity()).getId();
    }

    private void validateDuplicateScenario(ScenarioDto scenarioDto) {
        List<Scenario> findScenarios = scenarioRepository.findByName(scenarioDto.getName());

        if (!findScenarios.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 시나리오입니다.");
        }
    }

    public List<Scenario> findScenarios() {
        return scenarioRepository.findAll();
    }

    public Optional<Scenario> findById(Integer scenarioId) {
        return scenarioRepository.findById(scenarioId);
    }

    @Transactional
    public Integer saveAccidentPortFacility(AccidentPortFacilityDto accidentPortFacilityDto) {
        return accidentPortFacilityRepository.save(accidentPortFacilityDto.toEntity()).getId();
    }
}
