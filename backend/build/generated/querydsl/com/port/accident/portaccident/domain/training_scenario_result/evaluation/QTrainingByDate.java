package com.port.accident.portaccident.domain.training_scenario_result.evaluation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTrainingByDate is a Querydsl query type for TrainingByDate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTrainingByDate extends EntityPathBase<TrainingByDate> {

    private static final long serialVersionUID = 158760053L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTrainingByDate trainingByDate = new QTrainingByDate("trainingByDate");

    public final EnumPath<com.port.accident.portaccident.enums.CompletionStatus> completionCheck = createEnum("completionCheck", com.port.accident.portaccident.enums.CompletionStatus.class);

    public final StringPath details = createString("details");

    public final ListPath<EvaluationDetails, QEvaluationDetails> evaluationDetailsList = this.<EvaluationDetails, QEvaluationDetails>createList("evaluationDetailsList", EvaluationDetails.class, QEvaluationDetails.class, PathInits.DIRECT2);

    public final StringPath evaluationName = createString("evaluationName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult trainingResult;

    public QTrainingByDate(String variable) {
        this(TrainingByDate.class, forVariable(variable), INITS);
    }

    public QTrainingByDate(Path<? extends TrainingByDate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTrainingByDate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTrainingByDate(PathMetadata metadata, PathInits inits) {
        this(TrainingByDate.class, metadata, inits);
    }

    public QTrainingByDate(Class<? extends TrainingByDate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.trainingResult = inits.isInitialized("trainingResult") ? new com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult(forProperty("trainingResult")) : null;
    }

}

