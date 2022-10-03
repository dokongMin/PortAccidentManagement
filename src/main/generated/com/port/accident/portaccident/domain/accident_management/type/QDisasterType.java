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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDisasterType disasterType = new QDisasterType("disasterType");

    public final com.port.accident.portaccident.domain.accident_management.QAccidentInfo accidentInfo;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QDisasterType(String variable) {
        this(DisasterType.class, forVariable(variable), INITS);
    }

    public QDisasterType(Path<? extends DisasterType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDisasterType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDisasterType(PathMetadata metadata, PathInits inits) {
        this(DisasterType.class, metadata, inits);
    }

    public QDisasterType(Class<? extends DisasterType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accidentInfo = inits.isInitialized("accidentInfo") ? new com.port.accident.portaccident.domain.accident_management.QAccidentInfo(forProperty("accidentInfo")) : null;
    }

}

