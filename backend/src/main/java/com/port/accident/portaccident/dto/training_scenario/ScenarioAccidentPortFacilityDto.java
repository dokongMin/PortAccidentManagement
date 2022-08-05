package com.port.accident.portaccident.dto.training_scenario;


import com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility;
import com.port.accident.portaccident.enums.IncidentImpact;
import com.port.accident.portaccident.enums.IncidentLevel;
import com.port.accident.portaccident.enums.IncidentType;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;

@Data
public class ScenarioAccidentPortFacilityDto {

    private String name;
    private IncidentLevel incidentLevel;
    private IncidentImpact incidentImpact;
    private IncidentType incidentType;
    private String incidentDetailType;
    private String portArea;
    private List<AccidentPortFacility> accidentPortFacilityList;

    @QueryProjection
    public ScenarioAccidentPortFacilityDto(String name, IncidentLevel incidentLevel, IncidentImpact impact,
                                           IncidentType incidentType, String incidentDetailType, String portArea) {

        this.name = name;
        this.incidentLevel = incidentLevel;
        this.incidentImpact = impact;
        this.incidentType = incidentType;
        this.incidentDetailType = incidentDetailType;
        this.portArea = portArea;

    }
}
