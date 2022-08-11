package com.port.accident.portaccident.domain.training_scenario_result.elements;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTrainingParticipants is a Querydsl query type for TrainingParticipants
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTrainingParticipants extends EntityPathBase<TrainingParticipants> {

    private static final long serialVersionUID = 99607957L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTrainingParticipants trainingParticipants = new QTrainingParticipants("trainingParticipants");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> participantsId = createNumber("participantsId", Integer.class);

    public final com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult trainingResult;

    public QTrainingParticipants(String variable) {
        this(TrainingParticipants.class, forVariable(variable), INITS);
    }

    public QTrainingParticipants(Path<? extends TrainingParticipants> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTrainingParticipants(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTrainingParticipants(PathMetadata metadata, PathInits inits) {
        this(TrainingParticipants.class, metadata, inits);
    }

    public QTrainingParticipants(Class<? extends TrainingParticipants> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.trainingResult = inits.isInitialized("trainingResult") ? new com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult(forProperty("trainingResult"), inits.get("trainingResult")) : null;
    }

}

