package com.port.accident.portaccident.domain.training_scenario.elements;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccidentResponseActivity is a Querydsl query type for AccidentResponseActivity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccidentResponseActivity extends EntityPathBase<AccidentResponseActivity> {

    private static final long serialVersionUID = 537035954L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccidentResponseActivity accidentResponseActivity = new QAccidentResponseActivity("accidentResponseActivity");

    public final StringPath comment = createString("comment");

    public final DateTimePath<java.time.LocalDateTime> completePlaningTime = createDateTime("completePlaningTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath manager = createString("manager");

    public final com.port.accident.portaccident.domain.training_scenario.QScenario scenario;

    public QAccidentResponseActivity(String variable) {
        this(AccidentResponseActivity.class, forVariable(variable), INITS);
    }

    public QAccidentResponseActivity(Path<? extends AccidentResponseActivity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccidentResponseActivity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccidentResponseActivity(PathMetadata metadata, PathInits inits) {
        this(AccidentResponseActivity.class, metadata, inits);
    }

    public QAccidentResponseActivity(Class<? extends AccidentResponseActivity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.scenario = inits.isInitialized("scenario") ? new com.port.accident.portaccident.domain.training_scenario.QScenario(forProperty("scenario")) : null;
    }

}

