package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.EvaluationDetails;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate;
import com.port.accident.portaccident.exception.DoesNotExistException;
import com.port.accident.portaccident.repository.training_scenario_result.TrainingResultRepository;
import com.port.accident.portaccident.repository.training_scenario_result.element.TrainingParticipantsRepository;
import com.port.accident.portaccident.repository.training_scenario_result.element.TrainingPortFacilityRepository;
import com.port.accident.portaccident.repository.training_scenario_result.evaluation.EvaluationDetailsRepository;
import com.port.accident.portaccident.repository.training_scenario_result.evaluation.TrainingByDateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TrainingResultService {
    private final TrainingResultRepository trainingResultRepository;
    private final TrainingParticipantsRepository participantsRepository;
    private final TrainingPortFacilityRepository facilityRepository;
    private final TrainingByDateRepository byDateRepository;
    private final EvaluationDetailsRepository evaluationRepository;


    public Integer createTrainingResult(TrainingResult trainingResult) {
        TrainingResult savedResult = trainingResultRepository.save(trainingResult);
        return savedResult.getId();
    }

    public TrainingResult findByTrainingResultId(Integer id) {
        Optional<TrainingResult> byId = trainingResultRepository.findById(id);
        return byId.orElseThrow(() -> new DoesNotExistException());
    }

    public Integer createPortFacility(TrainingPortFacility facility) {
        TrainingPortFacility savedFacility = facilityRepository.save(facility);
        return savedFacility.getId();
    }

    public TrainingPortFacility findByFacilityId(Integer id) {
        Optional<TrainingPortFacility> byId = facilityRepository.findById(id);
        return byId.orElseThrow(() -> new DoesNotExistException());
    }

    public Integer createTrainingByDate(TrainingByDate resultByDate) {
        TrainingByDate savedResult = byDateRepository.save(resultByDate);
        return savedResult.getId();
    }

    public TrainingByDate findTrainingByDate(Integer id) {
        Optional<TrainingByDate> byId = byDateRepository.findById(id);
        return byId.orElseThrow(() -> new DoesNotExistException());
    }

    public Integer createTrainingParticipants(TrainingParticipants participants) {
        TrainingParticipants savedParticipants = participantsRepository.save(participants);
        return savedParticipants.getParticipantsId();
    }

    public TrainingParticipants findByParticipantId(Integer id) {
        Optional<TrainingParticipants> byId = participantsRepository.findById(id);
        return byId.orElseThrow(() -> new DoesNotExistException());

    }

    public Integer createEvaluationDetails(EvaluationDetails details) {
        EvaluationDetails savedDetail = evaluationRepository.save(details);
        return savedDetail.getId();
    }

    public EvaluationDetails findByEvaluationDetailId(Integer id) {
        Optional<EvaluationDetails> byId = evaluationRepository.findById(id);
        return byId.orElseThrow(() -> new DoesNotExistException());
    }

}
