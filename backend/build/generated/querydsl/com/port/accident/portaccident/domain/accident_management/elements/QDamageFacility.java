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

    public static final QDamageFacility damageFacility = new QDamageFacility("damageFacility");

    public final ListPath<DamageFacilityInfo, QDamageFacilityInfo> damageFacilityInfoList = this.<DamageFacilityInfo, QDamageFacilityInfo>createList("damageFacilityInfoList", DamageFacilityInfo.class, QDamageFacilityInfo.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QDamageFacility(String variable) {
        super(DamageFacility.class, forVariable(variable));
    }

    public QDamageFacility(Path<? extends DamageFacility> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDamageFacility(PathMetadata metadata) {
        super(DamageFacility.class, metadata);
    }

}

