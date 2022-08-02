package com.port.accident.portaccident.dto.training_scenario_result;


import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility;
import com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class TrainingResultDto {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String place;
    private String trainingType;
    private String accidentLevel;
    private String accidentImpact;
    private String precedingType;
    private String accidentType;
    private String disasterType;
    private String department;
    private String trainingArea;
    private List<TrainingPortFacility> trainingPortFacilityList = new ArrayList<>();
    private List<TrainingByDate> trainingByDateList = new ArrayList<>();
    private List<TrainingParticipants> trainingParticipantsList = new ArrayList<>();

    @Builder
    public TrainingResultDto(String name, LocalDateTime startDate, LocalDateTime endDate, String place,
                             String trainingType, String accidentLevel, String accidentImpact, String precedingType,
                             String accidentType, String disasterType, String department, String trainingArea,
                             List<TrainingPortFacility> trainingPortFacilityList,
                             List<TrainingByDate> trainingByDateList,
                             List<TrainingParticipants> trainingParticipantsList) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.trainingType = trainingType;
        this.accidentLevel = accidentLevel;
        this.accidentImpact = accidentImpact;
        this.precedingType = precedingType;
        this.accidentType = accidentType;
        this.disasterType = disasterType;
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
                .accidentLevel(accidentLevel)
                .accidentImpact(accidentImpact)
                .precedingType(precedingType)
                .accidentType(accidentType)
                .disasterType(disasterType)
                .department(department)
                .trainingArea(trainingArea)
                .trainingPortFacilityList(trainingPortFacilityList)
                .trainingByDateList(trainingByDateList)
                .trainingParticipantsList(trainingParticipantsList)
                .build();
    }
}
