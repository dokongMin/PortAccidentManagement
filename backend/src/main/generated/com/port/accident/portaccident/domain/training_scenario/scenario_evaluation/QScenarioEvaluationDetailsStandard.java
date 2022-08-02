package com.port.accident.portaccident.domain.training_scenario.scenario_evaluation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScenarioEvaluationDetailsStandard is a Querydsl query type for ScenarioEvaluationDetailsStandard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScenarioEvaluationDetailsStandard extends EntityPathBase<ScenarioEvaluationDetailsStandard> {

    private static final long serialVersionUID = 1124207468L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScenarioEvaluationDetailsStandard scenarioEvaluationDetailsStandard = new QScenarioEvaluationDetailsStandard("scenarioEvaluationDetailsStandard");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final QScenarioEvaluationStandard scenarioEvaluationStandard;

    public final ComparablePath<Character> suitableCheck = createComparable("suitableCheck", Character.class);

    public QScenarioEvaluationDetailsStandard(String variable) {
        this(ScenarioEvaluationDetailsStandard.class, forVariable(variable), INITS);
    }

    public QScenarioEvaluationDetailsStandard(Path<? extends ScenarioEvaluationDetailsStandard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScenarioEvaluationDetailsStandard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScenarioEvaluationDetailsStandard(PathMetadata metadata, PathInits inits) {
        this(ScenarioEvaluationDetailsStandard.class, metadata, inits);
    }

    public QScenarioEvaluationDetailsStandard(Class<? extends ScenarioEvaluationDetailsStandard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.scenarioEvaluationStandard = inits.isInitialized("scenarioEvaluationStandard") ? new QScenarioEvaluationStandard(forProperty("scenarioEvaluationStandard"), inits.get("scenarioEvaluationStandard")) : null;
    }

}

