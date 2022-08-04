package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.EvaluationDetails;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultDto;
import com.port.accident.portaccident.dto.training_scenario_result.elements.TrainingParticipantsDto;
import com.port.accident.portaccident.dto.training_scenario_result.elements.TrainingPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario_result.evaluation.EvaluationDetailsDto;
import com.port.accident.portaccident.dto.training_scenario_result.evaluation.TrainingByDateDto;
import com.port.accident.portaccident.enums.*;
import com.port.accident.portaccident.exception.DoesNotExistException;
import com.port.accident.portaccident.repository.training_scenario_result.TrainingResultRepository;
import com.port.accident.portaccident.repository.training_scenario_result.element.TrainingParticipantsRepository;
import com.port.accident.portaccident.repository.training_scenario_result.element.TrainingPortFacilityRepository;
import com.port.accident.portaccident.repository.training_scenario_result.evaluation.EvaluationDetailsRepository;
import com.port.accident.portaccident.repository.training_scenario_result.evaluation.TrainingByDateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    public TrainingByDate findTrainingByDateById(Integer id) {
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

    public void createTrainingResultUsingJsonString(Map<String, Object> param) {
        TrainingResultDto trainingResultDto = settingTrainingResultDtoUsingSplit(param);
        Integer result = createTrainingResult(trainingResultDto.toEntity());
        TrainingResult trainingResult = findByTrainingResultId(result);

        createTrainingPortFacilityList(param, trainingResult);
        createTrainingParticipantsList(param, trainingResult);
    }

    private void createTrainingParticipantsList(Map<String, Object> param, TrainingResult trainingResult) {
        String[] split = parsingJsonString(param, "TrainingParticipants", "[", "]");
        for (String participantsId : split) {
            TrainingParticipantsDto dto = TrainingParticipantsDto.builder()
                    .participantsId(Integer.parseInt(participantsId))
                    .trainingResult(trainingResult)
                    .build();
            Integer participantId = createTrainingParticipants(dto.toEntity());
            trainingResult.updateTrainingParticipantsList(findByParticipantId(participantId));
        }
    }

    private void createTrainingPortFacilityList(Map<String, Object> param, TrainingResult trainingResult) {
        String[] split = parsingJsonString(param, "TrainingPortFacilitys", "[", "]");
        for (String facility : split) {
            TrainingPortFacilityDto dto = matchingStringToEnumPortFacility(trainingResult, facility);
            Integer savedFacilityId = createPortFacility(dto.toEntity());
            trainingResult.updateTrainingPortFacilityList(findByFacilityId(savedFacilityId));   //오류날 확률 높음
        }
    }

    private TrainingPortFacilityDto matchingStringToEnumPortFacility(TrainingResult trainingResult, String facility) {
        TrainingPortFacilityDto dto = null;
        if (facility.equals("CRANE")) {
            dto = settingTrainingPortFacilityDto(trainingResult, PortFacility.CRANE);
        } else if (facility.equals("CONTAINER")) {
            dto = settingTrainingPortFacilityDto(trainingResult, PortFacility.CONTAINER);
        } else if (facility.equals("FORKLIFT")) {
            dto = settingTrainingPortFacilityDto(trainingResult, PortFacility.FORKLIFT);
        } else if (facility.equals("LADDER")) {
            dto = settingTrainingPortFacilityDto(trainingResult, PortFacility.LADDER);
        }
        return dto;
    }

    private TrainingPortFacilityDto settingTrainingPortFacilityDto(TrainingResult trainingResult, PortFacility ladder) {
        return TrainingPortFacilityDto.builder()
                .name(ladder)
                .trainingResult(trainingResult)
                .build();
    }

    private String[] parsingJsonString(Map<String, Object> param, String trainingPortFacilitys, String s, String s2) {
        return param.get(trainingPortFacilitys).toString().replace(s, "").replace(s2, "").replace(" ", "").split(",");
    }

    private TrainingResultDto settingTrainingResultDtoUsingSplit(Map<String, Object> param) {
        TrainingResultDto trainingResultDto = new TrainingResultDto();
        String[] trainingResultsElements = parsingTrainingResultsJsonString(param);
        for (String trainingResultsElement : trainingResultsElements) {
            String[] split = trainingResultsElement.split("=");
            if (split[0].equals("name")) {
                trainingResultDto.setName(split[1]);
            } else if (split[0].equals("startDate")) {
                LocalDateTime date = stringToLocalDateTime(split[1]);
                trainingResultDto.setStartDate(date);
            } else if (split[0].equals("endDate")) {
                LocalDateTime date = stringToLocalDateTime(split[1]);
                trainingResultDto.setEndDate(date);
            } else if (split[0].equals("place")) {
                matchingStringToEnumTrainingPlace(trainingResultDto, split);
            } else if (split[0].equals("trainingType")) {
                matchingStringToEnumTrainingType(trainingResultDto, split);
            } else if (split[0].equals("incidentLevel")) {
                matchingStringToEnumIncidentLevel(trainingResultDto, split);
            } else if (split[0].equals("incidentImpact")) {
                matchingStringToEnumIncidentImpact(trainingResultDto, split);
            } else if (split[0].equals("incidentType")) {
                matchingStringToEnumIncidentType(trainingResultDto, split);
            } else if (split[0].equals("department")) {
                trainingResultDto.setDepartment(split[1]);
            } else if (split[0].equals("trainingArea")) {
                trainingResultDto.setTrainingArea(split[1]);
            }
        }
        return trainingResultDto;
    }

    private LocalDateTime stringToLocalDateTime(String text) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA);
        return LocalDateTime.parse(text, dateTimeFormatter).plusHours(9);
    }

    private void matchingStringToEnumIncidentType(TrainingResultDto trainingResultDto, String[] split) {
        if (split[1].equals("ACCIDNET"))
            trainingResultDto.setIncidentType(IncidentType.ACCIDNET);
        else if (split[1].equals("DISASTER"))
            trainingResultDto.setIncidentType(IncidentType.DISASTER);
    }

    private void matchingStringToEnumIncidentImpact(TrainingResultDto trainingResultDto, String[] split) {
        if (split[1].equals("INCIDENT_IMPACT_A"))
            trainingResultDto.setIncidentImpact(IncidentImpact.INCIDENT_IMPACT_A);
        else if (split[1].equals("INCIDENT_IMPACT_B"))
            trainingResultDto.setIncidentImpact(IncidentImpact.INCIDENT_IMPACT_B);
        else if (split[1].equals("INCIDENT_IMPACT_C"))
            trainingResultDto.setIncidentImpact(IncidentImpact.INCIDENT_IMPACT_C);
        else if (split[1].equals("INCIDENT_IMPACT_D"))
            trainingResultDto.setIncidentImpact(IncidentImpact.INCIDENT_IMPACT_D);
    }

    private void matchingStringToEnumIncidentLevel(TrainingResultDto trainingResultDto, String[] split) {
        if (split[1].equals("LEVEL_1"))
            trainingResultDto.setIncidentLevel(IncidentLevel.LEVEL_1);
        else if (split[1].equals("LEVEL_2"))
            trainingResultDto.setIncidentLevel(IncidentLevel.LEVEL_2);
        else if (split[1].equals("LEVEL_3"))
            trainingResultDto.setIncidentLevel(IncidentLevel.LEVEL_3);
    }

    private void matchingStringToEnumTrainingType(TrainingResultDto trainingResultDto, String[] split) {
        if (split[1].equals("VIRTUAL"))
            trainingResultDto.setTrainingType(TrainingType.VIRTUAL);
        else if (split[1].equals("ACTUAL"))
            trainingResultDto.setTrainingType(TrainingType.ACTUAL);
    }

    private void matchingStringToEnumTrainingPlace(TrainingResultDto trainingResultDto, String[] split) {
        if (split[1].equals("PLACE1"))
            trainingResultDto.setPlace(TrainingPlace.PLACE1);
        else if (split[1].equals("PLACE2"))
            trainingResultDto.setPlace(TrainingPlace.PLACE2);
        else if (split[1].equals("PLACE3"))
            trainingResultDto.setPlace(TrainingPlace.PLACE3);
        else if (split[1].equals("PLACE4"))
            trainingResultDto.setPlace(TrainingPlace.PLACE4);
        else if (split[1].equals("PLACE5"))
            trainingResultDto.setPlace(TrainingPlace.PLACE5);
    }

    private String[] parsingTrainingResultsJsonString(Map<String, Object> param) {
        return parsingJsonString(param, "TrainingResult", "{", "}");
    }

    public void createEvaluationDetailsByDays(List<Map<String, Object>> param) {
        boolean isEvaluationDetails = false;
        int count = 0;
        TrainingByDateDto byDateDto = new TrainingByDateDto();
        List<String> names = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();

        for (Map<String, Object> stringObjectMap : param) {
            Object[] keys = stringObjectMap.keySet().stream().toArray();
            for (Object key : keys) {
                if (count == 4) isEvaluationDetails = true;
                if (isEvaluationDetails) {
                    settingNamesAndScoresList(names, scores, stringObjectMap, key);
                } else {
                    count = settingTrainingByDateDto(count, byDateDto, stringObjectMap, key);
                }
            }
        }
        Integer trainingByDateId = createTrainingByDate(byDateDto.toEntity());
        TrainingByDate trainingByDate = findTrainingByDateById(trainingByDateId);

        createEvaluationDetailsList(names, scores, trainingByDate);

    }

    private void createEvaluationDetailsList(List<String> names, List<Integer> scores, TrainingByDate trainingByDate) {
        for (int i = 0; i < names.size(); i++) {
            EvaluationDetailsDto detailsDto = settingEvaluationDetailsDto(names, scores, trainingByDate, i);
            createEvaluationDetails(detailsDto.toEntity());
        }
    }

    private EvaluationDetailsDto settingEvaluationDetailsDto(List<String> names, List<Integer> scores, TrainingByDate trainingByDate, int i) {
        EvaluationDetailsDto detailsDto = EvaluationDetailsDto.builder()
                .name(names.get(i))
                .score(scores.get(i))
                .trainingByDate(trainingByDate)
                .build();
        return detailsDto;
    }

    private void settingNamesAndScoresList(List<String> names, List<Integer> scores, Map<String, Object> stringObjectMap, Object key) {
        if (key.toString().equals("name")) {
            names.add((String) stringObjectMap.get(key));
        } else if (key.toString().equals("score")) {
            scores.add((Integer) stringObjectMap.get(key));
        }
    }

    private int settingTrainingByDateDto(int count, TrainingByDateDto byDateDto, Map<String, Object> stringObjectMap, Object key) {
        if (key.toString().equals("details")) {
            count++;
            byDateDto.setDetails((String) stringObjectMap.get(key));
        } else if (key.toString().equals("completionCheck")) {
            count++;
            if (stringObjectMap.get(key).toString().equals("COMPLETE")) {
                byDateDto.setCompletionCheck(CompletionStatus.COMPLETE);
            } else if (stringObjectMap.get(key).toString().equals("NOT_COMPLETE")) {
                byDateDto.setCompletionCheck(CompletionStatus.NOT_COMPLETE);
            }
        } else if (key.toString().equals("evaluationName")) {
            count++;
            byDateDto.setEvaluationName((String) stringObjectMap.get(key));
        } else if (key.toString().equals("trainingResultId")) {
            TrainingResult trainingResult = findByTrainingResultId((Integer) stringObjectMap.get(key));
            count++;
            System.out.println("trainingResult : " + trainingResult.getId());
            byDateDto.setTrainingResult(trainingResult);
        }
        return count;
    }
}
