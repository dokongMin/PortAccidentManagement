package com.port.accident.portaccident.domain.training_scenario;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScenario is a Querydsl query type for Scenario
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScenario extends EntityPathBase<Scenario> {

    private static final long serialVersionUID = -1651469484L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScenario scenario = new QScenario("scenario");

    public final ListPath<com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility, com.port.accident.portaccident.domain.training_scenario.elements.QAccidentPortFacility> accidentPortFacilityList = this.<com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility, com.port.accident.portaccident.domain.training_scenario.elements.QAccidentPortFacility>createList("accidentPortFacilityList", com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility.class, com.port.accident.portaccident.domain.training_scenario.elements.QAccidentPortFacility.class, PathInits.DIRECT2);

    public final ListPath<com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity, com.port.accident.portaccident.domain.training_scenario.elements.QAccidentResponseActivity> accidentResponseActivityList = this.<com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity, com.port.accident.portaccident.domain.training_scenario.elements.QAccidentResponseActivity>createList("accidentResponseActivityList", com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity.class, com.port.accident.portaccident.domain.training_scenario.elements.QAccidentResponseActivity.class, PathInits.DIRECT2);

    public final StringPath accidentType = createString("accidentType");

    public final StringPath disasterType = createString("disasterType");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath impact = createString("impact");

    public final StringPath level = createString("level");

    public final StringPath name = createString("name");

    public final StringPath portArea = createString("portArea");

    public final StringPath precedingType = createString("precedingType");

    public final StringPath responseStage = createString("responseStage");

    public final com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.QScenarioEvaluation scenarioEvaluation;

    public final ListPath<com.port.accident.portaccident.domain.training_scenario_result.TrainingResult, com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult> trainingResultArrayList = this.<com.port.accident.portaccident.domain.training_scenario_result.TrainingResult, com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult>createList("trainingResultArrayList", com.port.accident.portaccident.domain.training_scenario_result.TrainingResult.class, com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult.class, PathInits.DIRECT2);

    public QScenario(String variable) {
        this(Scenario.class, forVariable(variable), INITS);
    }

    public QScenario(Path<? extends Scenario> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScenario(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScenario(PathMetadata metadata, PathInits inits) {
        this(Scenario.class, metadata, inits);
    }

    public QScenario(Class<? extends Scenario> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.scenarioEvaluation = inits.isInitialized("scenarioEvaluation") ? new com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.QScenarioEvaluation(forProperty("scenarioEvaluation"), inits.get("scenarioEvaluation")) : null;
    }

}

