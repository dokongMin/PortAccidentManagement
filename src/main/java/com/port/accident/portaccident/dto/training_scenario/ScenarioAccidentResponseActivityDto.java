package com.port.accident.portaccident.dto.training_scenario;


import com.port.accident.portaccident.enums.IncidentImpact;
import com.port.accident.portaccident.enums.IncidentLevel;
import com.port.accident.portaccident.enums.IncidentType;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class ScenarioAccidentResponseActivityDto {

    /*private String name;
    private IncidentLevel incidentLevel;
    private IncidentImpact incidentImpact;
    private IncidentType incidentType;
    private String incidentDetailType;
    private String portArea;
    private String responseStage;*/

    private String name;
    private IncidentImpact incidentImpact;
    private IncidentType incidentType;
    private String incidentDetailType;

    private IncidentLevel incidentLevel;
    private String comment;
    private String manager;

    @QueryProjection
    public ScenarioAccidentResponseActivityDto(String name, IncidentImpact impact, IncidentType incidentType,
                                               String incidentDetailType, IncidentLevel incidentLevel, String comment, String manager) {

        this.name = name;
        this.incidentImpact = impact;
        this.incidentType = incidentType;
        this.incidentDetailType = incidentDetailType;
        this.incidentLevel = incidentLevel;
        this.comment = comment;
        this.manager = manager;
    }
}
