package com.port.accident.portaccident.dto.training_scenario;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class ScenarioAccidentResponseActivityDto {

    private String name;
    private String level;
    private String impact;
    private String precedingType;
    private String accidentType;
    private String disasterType;
    private String comment;
    private String manager;

    @QueryProjection
    public ScenarioAccidentResponseActivityDto(String name, String level, String impact, String precedingType,
                                               String accidentType, String disasterType, String comment, String manager) {

        this.name = name;
        this.level = level;
        this.impact = impact;
        this.precedingType = precedingType;
        this.accidentType = accidentType;
        this.disasterType = disasterType;
        this.comment = comment;
        this.manager = manager;
    }
}
