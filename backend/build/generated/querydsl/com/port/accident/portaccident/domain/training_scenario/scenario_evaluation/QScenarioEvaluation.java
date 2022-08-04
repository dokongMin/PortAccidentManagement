package com.port.accident.portaccident.domain.training_scenario.scenario_evaluation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScenarioEvaluation is a Querydsl query type for ScenarioEvaluation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScenarioEvaluation extends EntityPathBase<ScenarioEvaluation> {

    private static final long serialVersionUID = -1739943117L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScenarioEvaluation scenarioEvaluation = new QScenarioEvaluation("scenarioEvaluation");

    public final EnumPath<SuitableCheck> completeStandard1 = createEnum("completeStandard1", SuitableCheck.class);

    public final EnumPath<SuitableCheck> completeStandard2 = createEnum("completeStandard2", SuitableCheck.class);

    public final EnumPath<SuitableCheck> developmentStandard1 = createEnum("developmentStandard1", SuitableCheck.class);

    public final EnumPath<SuitableCheck> developmentStandard2 = createEnum("developmentStandard2", SuitableCheck.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final EnumPath<SuitableCheck> possibleStandard1 = createEnum("possibleStandard1", SuitableCheck.class);

    public final EnumPath<SuitableCheck> possibleStandard2 = createEnum("possibleStandard2", SuitableCheck.class);

    public final com.port.accident.portaccident.domain.training_scenario.QScenario scenario;

    public QScenarioEvaluation(String variable) {
        this(ScenarioEvaluation.class, forVariable(variable), INITS);
    }

    public QScenarioEvaluation(Path<? extends ScenarioEvaluation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScenarioEvaluation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScenarioEvaluation(PathMetadata metadata, PathInits inits) {
        this(ScenarioEvaluation.class, metadata, inits);
    }

    public QScenarioEvaluation(Class<? extends ScenarioEvaluation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.scenario = inits.isInitialized("scenario") ? new com.port.accident.portaccident.domain.training_scenario.QScenario(forProperty("scenario")) : null;
    }

}

