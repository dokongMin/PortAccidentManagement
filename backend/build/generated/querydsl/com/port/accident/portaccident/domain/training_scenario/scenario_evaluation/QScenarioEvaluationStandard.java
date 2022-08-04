package com.port.accident.portaccident.domain.training_scenario.scenario_evaluation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScenarioEvaluationStandard is a Querydsl query type for ScenarioEvaluationStandard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScenarioEvaluationStandard extends EntityPathBase<ScenarioEvaluationStandard> {

    private static final long serialVersionUID = -708758768L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScenarioEvaluationStandard scenarioEvaluationStandard = new QScenarioEvaluationStandard("scenarioEvaluationStandard");

    public final StringPath evaluationDetailsStandard = createString("evaluationDetailsStandard");

    public final EnumPath<EvaluationStandard> evaluationStandard = createEnum("evaluationStandard", EvaluationStandard.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QScenarioEvaluation scenarioEvaluation;

    public final EnumPath<SuitableCheck> suitableCheck = createEnum("suitableCheck", SuitableCheck.class);

    public QScenarioEvaluationStandard(String variable) {
        this(ScenarioEvaluationStandard.class, forVariable(variable), INITS);
    }

    public QScenarioEvaluationStandard(Path<? extends ScenarioEvaluationStandard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScenarioEvaluationStandard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScenarioEvaluationStandard(PathMetadata metadata, PathInits inits) {
        this(ScenarioEvaluationStandard.class, metadata, inits);
    }

    public QScenarioEvaluationStandard(Class<? extends ScenarioEvaluationStandard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.scenarioEvaluation = inits.isInitialized("scenarioEvaluation") ? new QScenarioEvaluation(forProperty("scenarioEvaluation"), inits.get("scenarioEvaluation")) : null;
    }

}

