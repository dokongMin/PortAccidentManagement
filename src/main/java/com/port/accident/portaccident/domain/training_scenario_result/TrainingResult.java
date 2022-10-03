package com.port.accident.portaccident.domain.training_scenario_result;

import com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants;
import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility;
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
    private String place;

    @Column(name = "training_type")
    private String trainingType;

    @Column(name = "accident_level")
    private String accidentLevel;

    @Column(name = "accident_impact")
    private String accidentImpact;

    /**
     * precedingType : 사고 - 재난 둘 중에 어떤 유형인지 선택하기 위함
     */
    @Column(name = "accident_disaster_type")
    private String precedingType;

    @Column(name = "accident_type")
    private String accidentType;

    @Column(name = "disaster_type")
    private String disasterType;

    @Column(name = "training_department")
    private String department;

    @Column(name = "training_port_area")
    private String trainingArea;

    @OneToMany(mappedBy = "trainingResult")
    private List<TrainingPortFacility> trainingPortFacilityList = new ArrayList<>();

    @OneToMany(mappedBy = "trainingResult")
    private List<TrainingByDate> trainingByDateList = new ArrayList<>();

    @OneToMany(mappedBy = "trainingResult")
    private List<TrainingParticipants> trainingParticipantsList = new ArrayList<>();

    @Builder
    public TrainingResult(Integer id, String name, LocalDateTime startDate, LocalDateTime endDate, String place,
                          String trainingType, String accidentLevel, String accidentImpact, String precedingType,
                          String accidentType, String disasterType, String department, String trainingArea,
                          List<TrainingPortFacility> trainingPortFacilityList,
                          List<TrainingByDate> trainingByDateList,
                          List<TrainingParticipants> trainingParticipantsList) {
        this.id = id;
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
}
