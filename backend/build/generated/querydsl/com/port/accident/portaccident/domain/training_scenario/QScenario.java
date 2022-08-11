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

    public static final QScenario scenario = new QScenario("scenario");

    public final ListPath<com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility, com.port.accident.portaccident.domain.training_scenario.elements.QAccidentPortFacility> accidentPortFacilityList = this.<com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility, com.port.accident.portaccident.domain.training_scenario.elements.QAccidentPortFacility>createList("accidentPortFacilityList", com.port.accident.portaccident.domain.training_scenario.elements.AccidentPortFacility.class, com.port.accident.portaccident.domain.training_scenario.elements.QAccidentPortFacility.class, PathInits.DIRECT2);

    public final ListPath<com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity, com.port.accident.portaccident.domain.training_scenario.elements.QAccidentResponseActivity> accidentResponseActivityList = this.<com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity, com.port.accident.portaccident.domain.training_scenario.elements.QAccidentResponseActivity>createList("accidentResponseActivityList", com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity.class, com.port.accident.portaccident.domain.training_scenario.elements.QAccidentResponseActivity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final EnumPath<com.port.accident.portaccident.enums.IncidentDetailType> incidentDetailType = createEnum("incidentDetailType", com.port.accident.portaccident.enums.IncidentDetailType.class);

    public final EnumPath<com.port.accident.portaccident.enums.IncidentImpact> incidentImpact = createEnum("incidentImpact", com.port.accident.portaccident.enums.IncidentImpact.class);

    public final EnumPath<com.port.accident.portaccident.enums.IncidentLevel> incidentLevel = createEnum("incidentLevel", com.port.accident.portaccident.enums.IncidentLevel.class);

    public final EnumPath<com.port.accident.portaccident.enums.IncidentType> incidentType = createEnum("incidentType", com.port.accident.portaccident.enums.IncidentType.class);

    public final StringPath name = createString("name");

    public final EnumPath<com.port.accident.portaccident.enums.TrainingPlace> portArea = createEnum("portArea", com.port.accident.portaccident.enums.TrainingPlace.class);

    public final StringPath responseStage = createString("responseStage");

    public final ListPath<com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluation, com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.QScenarioEvaluation> scenarioEvaluationList = this.<com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluation, com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.QScenarioEvaluation>createList("scenarioEvaluationList", com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluation.class, com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.QScenarioEvaluation.class, PathInits.DIRECT2);

    public final ListPath<com.port.accident.portaccident.domain.training_scenario_result.TrainingResult, com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult> trainingResultArrayList = this.<com.port.accident.portaccident.domain.training_scenario_result.TrainingResult, com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult>createList("trainingResultArrayList", com.port.accident.portaccident.domain.training_scenario_result.TrainingResult.class, com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult.class, PathInits.DIRECT2);

    public QScenario(String variable) {
        super(Scenario.class, forVariable(variable));
    }

    public QScenario(Path<? extends Scenario> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScenario(PathMetadata metadata) {
        super(Scenario.class, metadata);
    }

}

