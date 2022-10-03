package com.port.accident.portaccident.dto.training_scenario_result;

import com.port.accident.portaccident.enums.IncidentLevel;
import com.port.accident.portaccident.enums.TrainingPlace;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class TrainingResultJoinScenarioDto {
    private Integer scenarioId;
    private String scenarioName;            //시나리오명
    private Integer trainingResultId;
    private String trainingName;            //훈련명
    private IncidentLevel incidentLevel;    //사고수준
    private String incidentDetailType;      //사고상세유형
    private TrainingPlace place;            //훈련장소
    private String department;              //훈련수행부서
    private String trainingArea;            //훈련대상항만구역

    @QueryProjection

    public TrainingResultJoinScenarioDto(Integer scenarioId, String scenarioName, Integer trainingResultId, String trainingName,
                                         IncidentLevel incidentLevel, String incidentDetailType, TrainingPlace place,
                                         String department, String trainingArea) {
        this.scenarioId = scenarioId;
        this.scenarioName = scenarioName;
        this.trainingResultId = trainingResultId;
        this.trainingName = trainingName;
        this.incidentLevel = incidentLevel;
        this.incidentDetailType = incidentDetailType;
        this.place = place;
        this.department = department;
        this.trainingArea = trainingArea;
    }
}
