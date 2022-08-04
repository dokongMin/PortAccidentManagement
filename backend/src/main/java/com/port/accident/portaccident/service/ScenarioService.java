package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity;
import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluation;
import com.port.accident.portaccident.dto.training_scenario.ScenarioAccidentResponseActivityDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioSearchCondition;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentResponseActivityDto;
import com.port.accident.portaccident.dto.training_scenario.scenario_evaluation.ScenarioEvaluationDto;
import com.port.accident.portaccident.dto.training_scenario_result.EvaluationSearchCondition;
import com.port.accident.portaccident.repository.training_scenario.AccidentPortFacilityRepository;
import com.port.accident.portaccident.repository.training_scenario.AccidentResponseActivityRepository;
import com.port.accident.portaccident.repository.training_scenario.ScenarioEvaluationRepository;
import com.port.accident.portaccident.repository.training_scenario.ScenarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final AccidentResponseActivityRepository accidentResponseActivityRepository;
    private final ScenarioEvaluationRepository scenarioEvaluationRepository;

    @Transactional
    public Integer registerScenario(ScenarioDto scenarioDto,
                                    List<AccidentPortFacilityDto> accidentPortFacilityDtoList,
                                    List<AccidentResponseActivityDto> accidentResponseActivityDtoList) {
        Integer scenarioId = saveScenario(scenarioDto);
        Scenario scenario = scenarioRepository.findById(scenarioId).get();


        saveAccidentPortFacility(scenario, accidentPortFacilityDtoList);
        saveAccidentResponseActivity(scenario, accidentResponseActivityDtoList);

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
    public void saveAccidentPortFacility(Scenario scenario, List<AccidentPortFacilityDto> accidentPortFacilityDtoList) {
        for (AccidentPortFacilityDto accidentPortFacilityDto : accidentPortFacilityDtoList) {
            scenario.addAccidentPortFacility(accidentPortFacilityDto);
        }
    }

    @Transactional
    public void saveAccidentResponseActivity(Scenario scenario, List<AccidentResponseActivityDto> accidentResponseActivityDtoList) {
        for (AccidentResponseActivityDto accidentResponseActivityDto : accidentResponseActivityDtoList) {
            validateDuplicateAccidentResponseActivity(accidentResponseActivityDto);
            scenario.addAccidentResponseActivity(accidentResponseActivityDto);
        }
    }

    private void validateDuplicateAccidentResponseActivity(AccidentResponseActivityDto accidentResponseActivityDto) {
        Optional<AccidentResponseActivity> findAccidentResponseActivity
                = accidentResponseActivityRepository.findByIncidentLevel(accidentResponseActivityDto.getIncidentLevel());

        if (findAccidentResponseActivity.isPresent()) {
            throw new IllegalStateException("이미 존재하는 사고 수준입니다.");
        }
    }

    @Transactional
    public Integer updateScenario(ScenarioDto scenarioDto) {
        Scenario scenario = scenarioRepository.findById(scenarioDto.getId()).get();
        scenario.update(scenarioDto);

        return scenarioRepository.save(scenario).getId();
    }

    @Transactional
    public Integer modifyAccidentPortFacility(Scenario scenario, List<AccidentPortFacilityDto> accidentPortFacilityDtoList) {
        deleteAccidentPortFacility(scenario);
        saveAccidentPortFacility(scenario, accidentPortFacilityDtoList);

        return scenario.getId();
    }

    @Transactional
    public void deleteAccidentPortFacility(Scenario scenario) {
        List<AccidentPortFacility> accidentPortFacilityList = accidentPortFacilityRepository.findByScenarioId(scenario.getId());
        scenario.removeAccidentPortFacility(accidentPortFacilityList);
    }

    @Transactional
    public Integer modifyAccidentResponseActivity(Scenario scenario, List<AccidentResponseActivityDto> accidentResponseActivityDtoList) {
        deleteAccidentResponseActivity(scenario);
        saveAccidentResponseActivity(scenario, accidentResponseActivityDtoList);

        return scenario.getId();
    }

    @Transactional
    public void deleteAccidentResponseActivity(Scenario scenario) {
        List<AccidentResponseActivity> accidentResponseActivityList = accidentResponseActivityRepository.findByScenarioId(scenario.getId());
        scenario.removeAccidentResponseActivity(accidentResponseActivityList);
    }

    @Transactional
    public void deleteScenario(Integer scenarioId) {
        scenarioRepository.deleteById(scenarioId);
    }

    public Page<ScenarioAccidentResponseActivityDto> searchPageScenario(ScenarioSearchCondition condition, Pageable pageable) {
        return scenarioRepository.searchPageScenario(condition, pageable);
    }

    /*
     * 시나리오 평가
     * */

    public Integer registerScenarioEvaluation(String scenarioName, ScenarioEvaluationDto scenarioEvaluationDto) {
        Scenario scenario = scenarioRepository.findByName(scenarioName).get();
        scenario.addScenarioEvaluation(scenarioEvaluationDto);

        return saveScenarioEvaluation(scenarioEvaluationDto);
    }

    @Transactional
    public Integer saveScenarioEvaluation(ScenarioEvaluationDto scenarioEvaluationDto) {
        validateDuplicateScenarioEvaluation(scenarioEvaluationDto); // 중복 시나리오 평가 검증

        return scenarioEvaluationRepository.save(scenarioEvaluationDto.toEntity()).getId();
    }

    private void validateDuplicateScenarioEvaluation(ScenarioEvaluationDto scenarioEvaluationDto) {
        Optional<ScenarioEvaluation> findScenarioEvaluation = scenarioEvaluationRepository.findByName(scenarioEvaluationDto.getName());

        if (findScenarioEvaluation.isPresent()) {
            throw new IllegalStateException("이미 존재하는 시나리오 평가입니다.");
        }
    }

    @Transactional
    public Integer updateScenarioEvaluation(ScenarioEvaluationDto scenarioEvaluationDto) {
        ScenarioEvaluation scenarioEvaluation = scenarioEvaluationRepository.findById(scenarioEvaluationDto.getId()).get();
        scenarioEvaluation.update(scenarioEvaluationDto);

        return scenarioEvaluationRepository.save(scenarioEvaluationDto.toEntity()).getId();
    }

    @Transactional
    public void deleteScenarioEvaluation(Integer scenarioEvaluationId) {
        scenarioEvaluationRepository.deleteById(scenarioEvaluationId);
    }

}
