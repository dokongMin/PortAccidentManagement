package com.port.accident.portaccident.domain.code;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRepresentativeCode is a Querydsl query type for RepresentativeCode
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRepresentativeCode extends EntityPathBase<RepresentativeCode> {

    private static final long serialVersionUID = 1999443872L;

    public static final QRepresentativeCode representativeCode = new QRepresentativeCode("representativeCode");

    public final StringPath code = createString("code");

    public final ListPath<DetailedCode, QDetailedCode> detailedCode = this.<DetailedCode, QDetailedCode>createList("detailedCode", DetailedCode.class, QDetailedCode.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QRepresentativeCode(String variable) {
        super(RepresentativeCode.class, forVariable(variable));
    }

    public QRepresentativeCode(Path<? extends RepresentativeCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRepresentativeCode(PathMetadata metadata) {
        super(RepresentativeCode.class, metadata);
    }

}

