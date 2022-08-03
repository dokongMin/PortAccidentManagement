package com.port.accident.portaccident.domain.accident_management.elements;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCausesSafetyAccident is a Querydsl query type for CausesSafetyAccident
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCausesSafetyAccident extends EntityPathBase<CausesSafetyAccident> {

    private static final long serialVersionUID = 1921442748L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCausesSafetyAccident causesSafetyAccident = new QCausesSafetyAccident("causesSafetyAccident");

    public final com.port.accident.portaccident.domain.accident_management.QAccidentInfo accidentInfo;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QCausesSafetyAccident(String variable) {
        this(CausesSafetyAccident.class, forVariable(variable), INITS);
    }

    public QCausesSafetyAccident(Path<? extends CausesSafetyAccident> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCausesSafetyAccident(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCausesSafetyAccident(PathMetadata metadata, PathInits inits) {
        this(CausesSafetyAccident.class, metadata, inits);
    }

    public QCausesSafetyAccident(Class<? extends CausesSafetyAccident> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accidentInfo = inits.isInitialized("accidentInfo") ? new com.port.accident.portaccident.domain.accident_management.QAccidentInfo(forProperty("accidentInfo")) : null;
    }

}

