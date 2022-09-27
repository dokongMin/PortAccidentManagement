package com.port.accident.portaccident.dto.training_scenario;


import com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility;
import com.port.accident.portaccident.enums.*;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;

@Data
public class ScenarioAccidentPortFacilityDto {

    private Integer id;
    private String name;
    private IncidentLevel incidentLevel;
    private IncidentImpact incidentImpact;
    private IncidentType incidentType;
    private IncidentDetailType incidentDetailType;
    private TrainingPlace portArea;
//    private List<AccidentPortFacility> accidentPortFacilityList;

    @QueryProjection
    public ScenarioAccidentPortFacilityDto(Integer id, String name, IncidentLevel incidentLevel, IncidentImpact impact,
                                           IncidentType incidentType, IncidentDetailType incidentDetailType, TrainingPlace portArea) {
        this.id = id;
        this.name = name;
        this.incidentLevel = incidentLevel;
        this.incidentImpact = impact;
        this.incidentType = incidentType;
        this.incidentDetailType = incidentDetailType;
        this.portArea = portArea;
    }
}
