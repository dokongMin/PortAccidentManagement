package com.port.accident.portaccident.dto.training_scenario_result;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.port.accident.portaccident.dto.training_scenario_result.QTrainingResultJoinScenarioDto is a Querydsl Projection type for TrainingResultJoinScenarioDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QTrainingResultJoinScenarioDto extends ConstructorExpression<TrainingResultJoinScenarioDto> {

    private static final long serialVersionUID = -1918083883L;

    public QTrainingResultJoinScenarioDto(com.querydsl.core.types.Expression<Integer> scenarioId, com.querydsl.core.types.Expression<String> scenarioName, com.querydsl.core.types.Expression<Integer> trainingResultId, com.querydsl.core.types.Expression<String> trainingName, com.querydsl.core.types.Expression<com.port.accident.portaccident.enums.IncidentLevel> incidentLevel, com.querydsl.core.types.Expression<String> incidentDetailType, com.querydsl.core.types.Expression<com.port.accident.portaccident.enums.TrainingPlace> place, com.querydsl.core.types.Expression<String> department, com.querydsl.core.types.Expression<String> trainingArea) {
        super(TrainingResultJoinScenarioDto.class, new Class<?>[]{int.class, String.class, int.class, String.class, com.port.accident.portaccident.enums.IncidentLevel.class, String.class, com.port.accident.portaccident.enums.TrainingPlace.class, String.class, String.class}, scenarioId, scenarioName, trainingResultId, trainingName, incidentLevel, incidentDetailType, place, department, trainingArea);
    }

}

