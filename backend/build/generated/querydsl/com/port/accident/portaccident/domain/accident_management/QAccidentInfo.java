package com.port.accident.portaccident.domain.accident_management;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccidentInfo is a Querydsl query type for AccidentInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccidentInfo extends EntityPathBase<AccidentInfo> {

    private static final long serialVersionUID = 407498755L;

    public static final QAccidentInfo accidentInfo = new QAccidentInfo("accidentInfo");

    public final StringPath accidentArea = createString("accidentArea");

    public final DateTimePath<java.time.LocalDateTime> accidentDate = createDateTime("accidentDate", java.time.LocalDateTime.class);

    public final StringPath accidentImpact = createString("accidentImpact");

    public final StringPath accidentLevel = createString("accidentLevel");

    public final StringPath accidentManager = createString("accidentManager");

    public final StringPath accidentPath = createString("accidentPath");

    public final ListPath<com.port.accident.portaccident.domain.accident_management.type.AccidentType, com.port.accident.portaccident.domain.accident_management.type.QAccidentType> accidentTypeList = this.<com.port.accident.portaccident.domain.accident_management.type.AccidentType, com.port.accident.portaccident.domain.accident_management.type.QAccidentType>createList("accidentTypeList", com.port.accident.portaccident.domain.accident_management.type.AccidentType.class, com.port.accident.portaccident.domain.accident_management.type.QAccidentType.class, PathInits.DIRECT2);

    public final ListPath<com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccident, com.port.accident.portaccident.domain.accident_management.elements.QCausesSafetyAccident> causesSafetyAccidentList = this.<com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccident, com.port.accident.portaccident.domain.accident_management.elements.QCausesSafetyAccident>createList("causesSafetyAccidentList", com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccident.class, com.port.accident.portaccident.domain.accident_management.elements.QCausesSafetyAccident.class, PathInits.DIRECT2);

    public final ListPath<com.port.accident.portaccident.domain.accident_management.elements.DamageFacility, com.port.accident.portaccident.domain.accident_management.elements.QDamageFacility> damageFacilityList = this.<com.port.accident.portaccident.domain.accident_management.elements.DamageFacility, com.port.accident.portaccident.domain.accident_management.elements.QDamageFacility>createList("damageFacilityList", com.port.accident.portaccident.domain.accident_management.elements.DamageFacility.class, com.port.accident.portaccident.domain.accident_management.elements.QDamageFacility.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath victim = createString("victim");

    public QAccidentInfo(String variable) {
        super(AccidentInfo.class, forVariable(variable));
    }

    public QAccidentInfo(Path<? extends AccidentInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccidentInfo(PathMetadata metadata) {
        super(AccidentInfo.class, metadata);
    }

}

