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

    public static final QTrainingResult trainingResult = new QTrainingResult("trainingResult");

    public final StringPath accidentImpact = createString("accidentImpact");

    public final StringPath accidentLevel = createString("accidentLevel");

    public final StringPath accidentType = createString("accidentType");

    public final StringPath department = createString("department");

    public final StringPath disasterType = createString("disasterType");

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath place = createString("place");

    public final StringPath precedingType = createString("precedingType");

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public final StringPath trainingArea = createString("trainingArea");

    public final ListPath<com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate, com.port.accident.portaccident.domain.training_scenario_result.evaluation.QTrainingByDate> trainingByDateList = this.<com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate, com.port.accident.portaccident.domain.training_scenario_result.evaluation.QTrainingByDate>createList("trainingByDateList", com.port.accident.portaccident.domain.training_scenario_result.evaluation.TrainingByDate.class, com.port.accident.portaccident.domain.training_scenario_result.evaluation.QTrainingByDate.class, PathInits.DIRECT2);

    public final ListPath<com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants, com.port.accident.portaccident.domain.training_scenario_result.elements.QTrainingParticipants> trainingParticipantsList = this.<com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants, com.port.accident.portaccident.domain.training_scenario_result.elements.QTrainingParticipants>createList("trainingParticipantsList", com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants.class, com.port.accident.portaccident.domain.training_scenario_result.elements.QTrainingParticipants.class, PathInits.DIRECT2);

    public final ListPath<com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility, com.port.accident.portaccident.domain.training_scenario_result.elements.QTrainingPortFacility> trainingPortFacilityList = this.<com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility, com.port.accident.portaccident.domain.training_scenario_result.elements.QTrainingPortFacility>createList("trainingPortFacilityList", com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility.class, com.port.accident.portaccident.domain.training_scenario_result.elements.QTrainingPortFacility.class, PathInits.DIRECT2);

    public final StringPath trainingType = createString("trainingType");

    public QTrainingResult(String variable) {
        super(TrainingResult.class, forVariable(variable));
    }

    public QTrainingResult(Path<? extends TrainingResult> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTrainingResult(PathMetadata metadata) {
        super(TrainingResult.class, metadata);
    }

}

