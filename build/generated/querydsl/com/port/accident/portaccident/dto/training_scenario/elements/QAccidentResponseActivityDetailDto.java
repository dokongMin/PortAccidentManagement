package com.port.accident.portaccident.dto.training_scenario.elements;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.port.accident.portaccident.dto.training_scenario.elements.QAccidentResponseActivityDetailDto is a Querydsl Projection type for AccidentResponseActivityDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAccidentResponseActivityDetailDto extends ConstructorExpression<AccidentResponseActivityDetailDto> {

    private static final long serialVersionUID = 264259743L;

    public QAccidentResponseActivityDetailDto(com.querydsl.core.types.Expression<Integer> id, com.querydsl.core.types.Expression<String> comment, com.querydsl.core.types.Expression<String> manager, com.querydsl.core.types.Expression<java.time.LocalDateTime> completePlaningTime) {
        super(AccidentResponseActivityDetailDto.class, new Class<?>[]{int.class, String.class, String.class, java.time.LocalDateTime.class}, id, comment, manager, completePlaningTime);
    }

}

