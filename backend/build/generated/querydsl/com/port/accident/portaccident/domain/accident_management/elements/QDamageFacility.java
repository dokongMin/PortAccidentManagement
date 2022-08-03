package com.port.accident.portaccident.domain.accident_management.elements;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDamageFacility is a Querydsl query type for DamageFacility
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDamageFacility extends EntityPathBase<DamageFacility> {

    private static final long serialVersionUID = 1631794403L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDamageFacility damageFacility = new QDamageFacility("damageFacility");

    public final com.port.accident.portaccident.domain.accident_management.QAccidentInfo accidentInfo;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QDamageFacility(String variable) {
        this(DamageFacility.class, forVariable(variable), INITS);
    }

    public QDamageFacility(Path<? extends DamageFacility> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDamageFacility(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDamageFacility(PathMetadata metadata, PathInits inits) {
        this(DamageFacility.class, metadata, inits);
    }

    public QDamageFacility(Class<? extends DamageFacility> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accidentInfo = inits.isInitialized("accidentInfo") ? new com.port.accident.portaccident.domain.accident_management.QAccidentInfo(forProperty("accidentInfo")) : null;
    }

}

