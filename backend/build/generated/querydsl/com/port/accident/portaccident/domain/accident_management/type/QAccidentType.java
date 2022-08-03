package com.port.accident.portaccident.domain.accident_management.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccidentType is a Querydsl query type for AccidentType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccidentType extends EntityPathBase<AccidentType> {

    private static final long serialVersionUID = 16189303L;

    public static final QAccidentType accidentType = new QAccidentType("accidentType");

    public final ListPath<com.port.accident.portaccident.domain.accident_management.AccidentInfo, com.port.accident.portaccident.domain.accident_management.QAccidentInfo> accidentInfoList = this.<com.port.accident.portaccident.domain.accident_management.AccidentInfo, com.port.accident.portaccident.domain.accident_management.QAccidentInfo>createList("accidentInfoList", com.port.accident.portaccident.domain.accident_management.AccidentInfo.class, com.port.accident.portaccident.domain.accident_management.QAccidentInfo.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QAccidentType(String variable) {
        super(AccidentType.class, forVariable(variable));
    }

    public QAccidentType(Path<? extends AccidentType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccidentType(PathMetadata metadata) {
        super(AccidentType.class, metadata);
    }

}

