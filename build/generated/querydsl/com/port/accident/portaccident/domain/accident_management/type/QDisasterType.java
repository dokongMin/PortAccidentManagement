package com.port.accident.portaccident.domain.accident_management.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDisasterType is a Querydsl query type for DisasterType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDisasterType extends EntityPathBase<DisasterType> {

    private static final long serialVersionUID = 1477644105L;

    public static final QDisasterType disasterType = new QDisasterType("disasterType");

    public final ListPath<com.port.accident.portaccident.domain.accident_management.AccidentInfo, com.port.accident.portaccident.domain.accident_management.QAccidentInfo> accidentInfoList = this.<com.port.accident.portaccident.domain.accident_management.AccidentInfo, com.port.accident.portaccident.domain.accident_management.QAccidentInfo>createList("accidentInfoList", com.port.accident.portaccident.domain.accident_management.AccidentInfo.class, com.port.accident.portaccident.domain.accident_management.QAccidentInfo.class, PathInits.DIRECT2);

    public final EnumPath<DisasterTypeEnum> disasterTypeEnum = createEnum("disasterTypeEnum", DisasterTypeEnum.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QDisasterType(String variable) {
        super(DisasterType.class, forVariable(variable));
    }

    public QDisasterType(Path<? extends DisasterType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDisasterType(PathMetadata metadata) {
        super(DisasterType.class, metadata);
    }

}

