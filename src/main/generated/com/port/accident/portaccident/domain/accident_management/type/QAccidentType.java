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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccidentType accidentType = new QAccidentType("accidentType");

    public final com.port.accident.portaccident.domain.accident_management.QAccidentInfo accidentInfo;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QAccidentType(String variable) {
        this(AccidentType.class, forVariable(variable), INITS);
    }

    public QAccidentType(Path<? extends AccidentType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccidentType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccidentType(PathMetadata metadata, PathInits inits) {
        this(AccidentType.class, metadata, inits);
    }

    public QAccidentType(Class<? extends AccidentType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accidentInfo = inits.isInitialized("accidentInfo") ? new com.port.accident.portaccident.domain.accident_management.QAccidentInfo(forProperty("accidentInfo")) : null;
    }

}

