package com.port.accident.portaccident.domain.training_scenario_result.elements;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTrainingPortFacility is a Querydsl query type for TrainingPortFacility
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTrainingPortFacility extends EntityPathBase<TrainingPortFacility> {

    private static final long serialVersionUID = -2109650887L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTrainingPortFacility trainingPortFacility = new QTrainingPortFacility("trainingPortFacility");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final EnumPath<com.port.accident.portaccident.enums.PortFacility> name = createEnum("name", com.port.accident.portaccident.enums.PortFacility.class);

    public final com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult trainingResult;

    public QTrainingPortFacility(String variable) {
        this(TrainingPortFacility.class, forVariable(variable), INITS);
    }

    public QTrainingPortFacility(Path<? extends TrainingPortFacility> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTrainingPortFacility(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTrainingPortFacility(PathMetadata metadata, PathInits inits) {
        this(TrainingPortFacility.class, metadata, inits);
    }

    public QTrainingPortFacility(Class<? extends TrainingPortFacility> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.trainingResult = inits.isInitialized("trainingResult") ? new com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult(forProperty("trainingResult")) : null;
    }

}

