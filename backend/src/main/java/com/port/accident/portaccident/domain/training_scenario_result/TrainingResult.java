package com.port.accident.portaccident.domain.training_scenario_result;

import com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility;
import com.port.accident.portaccident.enums.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "training_result")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TrainingResult {

    @Id
    @Column(name = "training_result_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "training_name")
    private String name;

    @Column(name = "training_start_date")
    private LocalDateTime startDate;
    @Column(name = "training_end_date")
    private LocalDateTime endDate;

    @Column(name = "training_place")
    private TrainingPlace place;

    @Column(name = "training_type")
    private TrainingType trainingType;

    @Column(name = "accident_level")
    private IncidentLevel incidentLevel;

    @Column(name = "incident_impact")
    private IncidentImpact incidentImpact;

    @Column(name = "incident_type")
    private IncidentType incidentType;

    @Column(name = "training_department")
    private String department;

    @Column(name = "training_port_area")
    private String trainingArea;    //훈련대상 항만구역

    @OneToMany(mappedBy = "trainingResult")
    private List<TrainingPortFacility> trainingPortFacilityList = new ArrayList<>();

    @OneToMany(mappedBy = "trainingResult")
    private List<TrainingByDate> trainingByDateList = new ArrayList<>();

    @OneToMany(mappedBy = "trainingResult")
    private List<TrainingParticipants> trainingParticipantsList = new ArrayList<>();

    @Builder

    public TrainingResult(Integer id, String name, LocalDateTime startDate, LocalDateTime endDate, TrainingPlace place,
                          TrainingType trainingType, IncidentLevel incidentLevel, IncidentImpact incidentImpact, IncidentType incidentType,
                          String department, String trainingArea) {
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
    }

    public void setTrainingPortFacilityList(List<TrainingPortFacility> trainingPortFacilityList) {
        this.trainingPortFacilityList = trainingPortFacilityList;
    }

    public void setTrainingByDateList(List<TrainingByDate> trainingByDateList) {
        this.trainingByDateList = trainingByDateList;
    }

    public void setTrainingParticipantsList(List<TrainingParticipants> trainingParticipantsList) {
        this.trainingParticipantsList = trainingParticipantsList;
    }
}
