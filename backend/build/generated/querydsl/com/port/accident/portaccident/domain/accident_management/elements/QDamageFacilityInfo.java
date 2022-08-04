package com.port.accident.portaccident.domain.accident_management.elements;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDamageFacilityInfo is a Querydsl query type for DamageFacilityInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDamageFacilityInfo extends EntityPathBase<DamageFacilityInfo> {

    private static final long serialVersionUID = -248847311L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDamageFacilityInfo damageFacilityInfo = new QDamageFacilityInfo("damageFacilityInfo");

    public final com.port.accident.portaccident.domain.accident_management.QAccidentInfo accidentInfo;

    public final EnumPath<DamageFacilityEnum> damageFacilityEnum = createEnum("damageFacilityEnum", DamageFacilityEnum.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QDamageFacilityInfo(String variable) {
        this(DamageFacilityInfo.class, forVariable(variable), INITS);
    }

    public QDamageFacilityInfo(Path<? extends DamageFacilityInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDamageFacilityInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDamageFacilityInfo(PathMetadata metadata, PathInits inits) {
        this(DamageFacilityInfo.class, metadata, inits);
    }

    public QDamageFacilityInfo(Class<? extends DamageFacilityInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accidentInfo = inits.isInitialized("accidentInfo") ? new com.port.accident.portaccident.domain.accident_management.QAccidentInfo(forProperty("accidentInfo"), inits.get("accidentInfo")) : null;
    }

}

