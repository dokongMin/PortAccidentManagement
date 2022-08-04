package com.port.accident.portaccident.domain.training_scenario_result;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTrainingResult is a Querydsl query type for TrainingResult
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTrainingResult extends EntityPathBase<TrainingResult> {

    private static final long serialVersionUID = 1112766195L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTrainingResult trainingResult = new QTrainingResult("trainingResult");

    public final StringPath department = createString("department");

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath incidentDetailType = createString("incidentDetailType");

    public final EnumPath<com.port.accident.portaccident.enums.IncidentImpact> incidentImpact = createEnum("incidentImpact", com.port.accident.portaccident.enums.IncidentImpact.class);

    public final EnumPath<com.port.accident.portaccident.enums.IncidentLevel> incidentLevel = createEnum("incidentLevel", com.port.accident.portaccident.enums.IncidentLevel.class);

    public final EnumPath<com.port.accident.portaccident.enums.IncidentType> incidentType = createEnum("incidentType", com.port.accident.portaccident.enums.IncidentType.class);

    public final StringPath name = createString("name");

    public final EnumPath<com.port.accident.portaccident.enums.TrainingPlace> place = createEnum("place", com.port.accident.portaccident.enums.TrainingPlace.class);

    public final com.port.accident.portaccident.domain.training_scenario.QScenario scenario;

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public final StringPath trainingArea = createString("trainingArea");

    public final ListPath<com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate, com.port.accident.portaccident.domain.training_scenario_result.evaluation.QTrainingByDate> trainingByDateList = this.<com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate, com.port.accident.portaccident.domain.training_scenario_result.evaluation.QTrainingByDate>createList("trainingByDateList", com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate.class, com.port.accident.portaccident.domain.training_scenario_result.evaluation.QTrainingByDate.class, PathInits.DIRECT2);

    public final ListPath<com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants, com.port.accident.portaccident.domain.training_scenario_result.elements.QTrainingParticipants> trainingParticipantsList = this.<com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants, com.port.accident.portaccident.domain.training_scenario_result.elements.QTrainingParticipants>createList("trainingParticipantsList", com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants.class, com.port.accident.portaccident.domain.training_scenario_result.elements.QTrainingParticipants.class, PathInits.DIRECT2);

    public final ListPath<com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility, com.port.accident.portaccident.domain.training_scenario_result.elements.QTrainingPortFacility> trainingPortFacilityList = this.<com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility, com.port.accident.portaccident.domain.training_scenario_result.elements.QTrainingPortFacility>createList("trainingPortFacilityList", com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility.class, com.port.accident.portaccident.domain.training_scenario_result.elements.QTrainingPortFacility.class, PathInits.DIRECT2);

    public final EnumPath<com.port.accident.portaccident.enums.TrainingType> trainingType = createEnum("trainingType", com.port.accident.portaccident.enums.TrainingType.class);

    public QTrainingResult(String variable) {
        this(TrainingResult.class, forVariable(variable), INITS);
    }

    public QTrainingResult(Path<? extends TrainingResult> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTrainingResult(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTrainingResult(PathMetadata metadata, PathInits inits) {
        this(TrainingResult.class, metadata, inits);
    }

    public QTrainingResult(Class<? extends TrainingResult> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.scenario = inits.isInitialized("scenario") ? new com.port.accident.portaccident.domain.training_scenario.QScenario(forProperty("scenario"), inits.get("scenario")) : null;
    }

}

