package com.port.accident.portaccident.dto.training_scenario;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.port.accident.portaccident.dto.training_scenario.QScenarioAccidentPortFacilityDto is a Querydsl Projection type for ScenarioAccidentPortFacilityDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QScenarioAccidentPortFacilityDto extends ConstructorExpression<ScenarioAccidentPortFacilityDto> {

    private static final long serialVersionUID = -1696920715L;

    public QScenarioAccidentPortFacilityDto(com.querydsl.core.types.Expression<Integer> id, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<com.port.accident.portaccident.enums.IncidentLevel> incidentLevel, com.querydsl.core.types.Expression<com.port.accident.portaccident.enums.IncidentImpact> impact, com.querydsl.core.types.Expression<com.port.accident.portaccident.enums.IncidentType> incidentType, com.querydsl.core.types.Expression<com.port.accident.portaccident.enums.IncidentDetailType> incidentDetailType, com.querydsl.core.types.Expression<com.port.accident.portaccident.enums.TrainingPlace> portArea) {
        super(ScenarioAccidentPortFacilityDto.class, new Class<?>[]{int.class, String.class, com.port.accident.portaccident.enums.IncidentLevel.class, com.port.accident.portaccident.enums.IncidentImpact.class, com.port.accident.portaccident.enums.IncidentType.class, com.port.accident.portaccident.enums.IncidentDetailType.class, com.port.accident.portaccident.enums.TrainingPlace.class}, id, name, incidentLevel, impact, incidentType, incidentDetailType, portArea);
    }

}

