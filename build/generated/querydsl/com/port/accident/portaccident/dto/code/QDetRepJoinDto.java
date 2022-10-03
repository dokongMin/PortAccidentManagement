package com.port.accident.portaccident.dto.code;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.port.accident.portaccident.dto.code.QDetRepJoinDto is a Querydsl Projection type for DetRepJoinDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QDetRepJoinDto extends ConstructorExpression<DetRepJoinDto> {

    private static final long serialVersionUID = 784606808L;

    public QDetRepJoinDto(com.querydsl.core.types.Expression<Integer> detId, com.querydsl.core.types.Expression<String> detName, com.querydsl.core.types.Expression<String> detCode, com.querydsl.core.types.Expression<String> comment, com.querydsl.core.types.Expression<String> repName) {
        super(DetRepJoinDto.class, new Class<?>[]{int.class, String.class, String.class, String.class, String.class}, detId, detName, detCode, comment, repName);
    }

}

