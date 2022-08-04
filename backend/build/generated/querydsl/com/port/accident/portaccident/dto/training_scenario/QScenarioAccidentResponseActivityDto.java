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

    public QScenarioAccidentResponseActivityDto(com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> level, com.querydsl.core.types.Expression<String> impact, com.querydsl.core.types.Expression<String> precedingType, com.querydsl.core.types.Expression<String> accidentType, com.querydsl.core.types.Expression<String> disasterType, com.querydsl.core.types.Expression<String> comment, com.querydsl.core.types.Expression<String> manager) {
        super(ScenarioAccidentResponseActivityDto.class, new Class<?>[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, name, level, impact, precedingType, accidentType, disasterType, comment, manager);
    }

}

