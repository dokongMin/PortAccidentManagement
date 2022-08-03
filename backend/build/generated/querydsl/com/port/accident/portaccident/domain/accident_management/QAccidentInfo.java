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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccidentInfo accidentInfo = new QAccidentInfo("accidentInfo");

    public final StringPath accidentArea = createString("accidentArea");

    public final DateTimePath<java.time.LocalDateTime> accidentDate = createDateTime("accidentDate", java.time.LocalDateTime.class);

    public final StringPath accidentImpact = createString("accidentImpact");

    public final StringPath accidentLevel = createString("accidentLevel");

    public final StringPath accidentManager = createString("accidentManager");

    public final StringPath accidentPath = createString("accidentPath");

    public final com.port.accident.portaccident.domain.accident_management.type.QAccidentType accidentType;

    public final ListPath<com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentInfo, com.port.accident.portaccident.domain.accident_management.elements.QCausesSafetyAccidentInfo> causesSafetyAccidentInfoList = this.<com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentInfo, com.port.accident.portaccident.domain.accident_management.elements.QCausesSafetyAccidentInfo>createList("causesSafetyAccidentInfoList", com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentInfo.class, com.port.accident.portaccident.domain.accident_management.elements.QCausesSafetyAccidentInfo.class, PathInits.DIRECT2);

    public final ListPath<com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo, com.port.accident.portaccident.domain.accident_management.elements.QDamageFacilityInfo> damageFacilityInfoList = this.<com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo, com.port.accident.portaccident.domain.accident_management.elements.QDamageFacilityInfo>createList("damageFacilityInfoList", com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo.class, com.port.accident.portaccident.domain.accident_management.elements.QDamageFacilityInfo.class, PathInits.DIRECT2);

    public final com.port.accident.portaccident.domain.accident_management.type.QDisasterType disasterType;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath victim = createString("victim");

    public QAccidentInfo(String variable) {
        this(AccidentInfo.class, forVariable(variable), INITS);
    }

    public QAccidentInfo(Path<? extends AccidentInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccidentInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccidentInfo(PathMetadata metadata, PathInits inits) {
        this(AccidentInfo.class, metadata, inits);
    }

    public QAccidentInfo(Class<? extends AccidentInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accidentType = inits.isInitialized("accidentType") ? new com.port.accident.portaccident.domain.accident_management.type.QAccidentType(forProperty("accidentType")) : null;
        this.disasterType = inits.isInitialized("disasterType") ? new com.port.accident.portaccident.domain.accident_management.type.QDisasterType(forProperty("disasterType")) : null;
    }

}

