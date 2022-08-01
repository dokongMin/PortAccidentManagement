package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
import com.port.accident.portaccident.repository.training_scenario.AccidentPortFacilityRepository;
import com.port.accident.portaccident.repository.training_scenario.ScenarioRepository;
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
    private final AccidentPortFacilityRepository accidentPortFacilityRepository;

    @Transactional
    public Integer registerScenario(ScenarioDto scenarioDto, List<AccidentPortFacilityDto> accidentPortFacilityDtoList) {
        Integer scenarioId = saveScenario(scenarioDto);
        Scenario scenario = scenarioRepository.findById(scenarioId).get();

        for (AccidentPortFacilityDto accidentPortFacilityDto : accidentPortFacilityDtoList) {
            accidentPortFacilityDto.setScenario(scenario);
            saveAccidentPortFacility(accidentPortFacilityDto);
        }
        return scenarioId;
    }

    @Transactional
    public Integer saveScenario(ScenarioDto scenarioDto) {
        validateDuplicateScenario(scenarioDto); // 중복 시나리오 검증

        return scenarioRepository.save(scenarioDto.toEntity()).getId();
    }

    private void validateDuplicateScenario(ScenarioDto scenarioDto) {
        Optional<Scenario> findScenario = scenarioRepository.findByName(scenarioDto.getName());

        if (findScenario.isPresent()) {
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

    @Transactional
    public Integer updateScenario(ScenarioDto scenarioDto) {
        Scenario scenario = scenarioRepository.findByName(scenarioDto.getName()).get();
        scenario.update(scenarioDto);

        return scenarioRepository.save(scenario).getId();
    }

    @Transactional
    public Integer modifyAccidentPortFacility(List<AccidentPortFacilityDto> accidentPortFacilityDtoList) {
        Scenario scenario = accidentPortFacilityDtoList.get(0).getScenario();

        deleteAccidentPortFacility(scenario);
        System.out.println("deleteAccidentPortFacility"+scenario.getAccidentPortFacilityList().size());

        updateAccidentPortFacility(accidentPortFacilityDtoList);
        System.out.println("updateAccidentPortFacility"+scenario.getAccidentPortFacilityList().size());

        scenario.addAccidentPortFacility(accidentPortFacilityDtoList);

        return scenario.getId();
    }

    @Transactional
    public void deleteAccidentPortFacility(Scenario scenario) {
        accidentPortFacilityRepository.deleteByScenarioId(scenario.getId());
    }

    @Transactional
    public void updateAccidentPortFacility(List<AccidentPortFacilityDto> accidentPortFacilityDtoList) {
        for (AccidentPortFacilityDto accidentPortFacilityDto : accidentPortFacilityDtoList) {
            saveAccidentPortFacility(accidentPortFacilityDto);
        }
    }

    @Transactional
    public void deleteScenario(Integer scenarioId) {
        scenarioRepository.deleteById(scenarioId);
    }
}
