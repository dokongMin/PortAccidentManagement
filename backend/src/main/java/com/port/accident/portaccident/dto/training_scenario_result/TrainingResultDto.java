package com.port.accident.portaccident.dto.training_scenario_result;


import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.EvaluationDetails;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate;
import com.port.accident.portaccident.enums.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class TrainingResultDto {
    private Integer id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private TrainingPlace place;
    private TrainingType trainingType;
    private IncidentLevel incidentLevel;
    private IncidentImpact incidentImpact;
    private IncidentType incidentType;
    private String department;
    private String trainingArea;
    private List<TrainingPortFacility> trainingPortFacilityList = new ArrayList<>();
    private List<TrainingByDate> trainingByDateList = new ArrayList<>();
    private List<TrainingParticipants> trainingParticipantsList = new ArrayList<>();

    @Builder
    public TrainingResultDto(Integer id, String name, LocalDateTime startDate, LocalDateTime endDate, TrainingPlace place, TrainingType trainingType, IncidentLevel incidentLevel, IncidentImpact incidentImpact, IncidentType incidentType, String department, String trainingArea, List<TrainingPortFacility> trainingPortFacilityList, List<TrainingByDate> trainingByDateList, List<TrainingParticipants> trainingParticipantsList) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.trainingType = trainingType;
        this.incidentLevel = incidentLevel;
        this.incidentImpact = incidentImpact;
        this.incidentType = incidentType;
        this.department = department;
        this.trainingArea = trainingArea;
        this.trainingPortFacilityList = trainingPortFacilityList;
        this.trainingByDateList = trainingByDateList;
        this.trainingParticipantsList = trainingParticipantsList;
    }



    public TrainingResult toEntity() {
        return TrainingResult.builder()
                .name(name)
                .startDate(startDate)
                .endDate(endDate)
                .place(place)
                .trainingType(trainingType)
                .incidentLevel(incidentLevel)
                .incidentImpact(incidentImpact)
                .incidentType(incidentType)
                .department(department)
                .trainingArea(trainingArea)
                .build();
    }
}
