package com.port.accident.portaccident.dto.training_scenario;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.port.accident.portaccident.dto.training_scenario.QScenarioAccidentResponseActivityDto is a Querydsl Projection type for ScenarioAccidentResponseActivityDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QScenarioAccidentResponseActivityDto extends ConstructorExpression<ScenarioAccidentResponseActivityDto> {

    private static final long serialVersionUID = -1122042167L;

    public QScenarioAccidentResponseActivityDto(com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<com.port.accident.portaccident.enums.IncidentLevel> incidentLevel, com.querydsl.core.types.Expression<com.port.accident.portaccident.enums.IncidentImpact> impact, com.querydsl.core.types.Expression<com.port.accident.portaccident.enums.IncidentType> incidentType, com.querydsl.core.types.Expression<String> incidentDetailType, com.querydsl.core.types.Expression<String> comment, com.querydsl.core.types.Expression<String> manager) {
        super(ScenarioAccidentResponseActivityDto.class, new Class<?>[]{String.class, com.port.accident.portaccident.enums.IncidentLevel.class, com.port.accident.portaccident.enums.IncidentImpact.class, com.port.accident.portaccident.enums.IncidentType.class, String.class, String.class, String.class}, name, incidentLevel, impact, incidentType, incidentDetailType, comment, manager);
    }

}

