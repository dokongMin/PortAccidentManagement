package com.port.accident.portaccident.domain.accident_management.elements;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCausesSafetyAccidentInfo is a Querydsl query type for CausesSafetyAccidentInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCausesSafetyAccidentInfo extends EntityPathBase<CausesSafetyAccidentInfo> {

    private static final long serialVersionUID = 1222213258L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCausesSafetyAccidentInfo causesSafetyAccidentInfo = new QCausesSafetyAccidentInfo("causesSafetyAccidentInfo");

    public final com.port.accident.portaccident.domain.accident_management.QAccidentInfo accidentInfo;

    public final QCausesSafetyAccident causesSafetyAccident;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QCausesSafetyAccidentInfo(String variable) {
        this(CausesSafetyAccidentInfo.class, forVariable(variable), INITS);
    }

    public QCausesSafetyAccidentInfo(Path<? extends CausesSafetyAccidentInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCausesSafetyAccidentInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCausesSafetyAccidentInfo(PathMetadata metadata, PathInits inits) {
        this(CausesSafetyAccidentInfo.class, metadata, inits);
    }

    public QCausesSafetyAccidentInfo(Class<? extends CausesSafetyAccidentInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accidentInfo = inits.isInitialized("accidentInfo") ? new com.port.accident.portaccident.domain.accident_management.QAccidentInfo(forProperty("accidentInfo"), inits.get("accidentInfo")) : null;
        this.causesSafetyAccident = inits.isInitialized("causesSafetyAccident") ? new QCausesSafetyAccident(forProperty("causesSafetyAccident")) : null;
    }

}

