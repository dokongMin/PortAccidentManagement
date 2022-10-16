package com.port.accident.portaccident.dto.training_scenario_result;

import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility;
import com.port.accident.portaccident.enums.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TrainingResultReturnToDto {
    private Integer id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private TrainingPlace place;
    private TrainingType trainingType;
    private IncidentLevel incidentLevel;
    private IncidentImpact incidentImpact;
    private IncidentType incidentType;
    private String incidentDetailType;
    private String department;
    private String trainingParticipants;
    private String trainingArea;
    private List<PortFacility> trainingPortFacilityList;

    public TrainingResultReturnToDto(Integer id, String name, LocalDateTime startDate, LocalDateTime endDate, TrainingPlace place, TrainingType trainingType, IncidentLevel incidentLevel, IncidentImpact incidentImpact, IncidentType incidentType, String incidentDetailType, String department, String trainingParticipants, String trainingArea) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.trainingType = trainingType;
        this.incidentLevel = incidentLevel;
        this.incidentImpact = incidentImpact;
        this.incidentType = incidentType;
        this.incidentDetailType = incidentDetailType;
        this.department = department;
        this.trainingParticipants = trainingParticipants;
        this.trainingArea = trainingArea;
    }

    public TrainingResultReturnToDto() {
        trainingPortFacilityList = new ArrayList<>();
    }

    public void addFacility(PortFacility facilityName) {
        trainingPortFacilityList.add(facilityName);
    }
}
