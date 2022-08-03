package com.port.accident.portaccident.domain.training_scenario.elements;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccidentPortFacility is a Querydsl query type for AccidentPortFacility
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccidentPortFacility extends EntityPathBase<AccidentPortFacility> {

    private static final long serialVersionUID = -1435650682L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccidentPortFacility accidentPortFacility = new QAccidentPortFacility("accidentPortFacility");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final com.port.accident.portaccident.domain.training_scenario.QScenario scenario;

    public QAccidentPortFacility(String variable) {
        this(AccidentPortFacility.class, forVariable(variable), INITS);
    }

    public QAccidentPortFacility(Path<? extends AccidentPortFacility> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccidentPortFacility(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccidentPortFacility(PathMetadata metadata, PathInits inits) {
        this(AccidentPortFacility.class, metadata, inits);
    }

    public QAccidentPortFacility(Class<? extends AccidentPortFacility> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.scenario = inits.isInitialized("scenario") ? new com.port.accident.portaccident.domain.training_scenario.QScenario(forProperty("scenario"), inits.get("scenario")) : null;
    }

}

