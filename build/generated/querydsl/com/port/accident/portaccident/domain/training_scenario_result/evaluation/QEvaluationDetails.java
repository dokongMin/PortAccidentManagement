package com.port.accident.portaccident.domain.training_scenario_result.evaluation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEvaluationDetails is a Querydsl query type for EvaluationDetails
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEvaluationDetails extends EntityPathBase<EvaluationDetails> {

    private static final long serialVersionUID = -210839216L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEvaluationDetails evaluationDetails = new QEvaluationDetails("evaluationDetails");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    public final QTrainingByDate trainingByDate;

    public QEvaluationDetails(String variable) {
        this(EvaluationDetails.class, forVariable(variable), INITS);
    }

    public QEvaluationDetails(Path<? extends EvaluationDetails> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEvaluationDetails(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEvaluationDetails(PathMetadata metadata, PathInits inits) {
        this(EvaluationDetails.class, metadata, inits);
    }

    public QEvaluationDetails(Class<? extends EvaluationDetails> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.trainingByDate = inits.isInitialized("trainingByDate") ? new QTrainingByDate(forProperty("trainingByDate"), inits.get("trainingByDate")) : null;
    }

}

