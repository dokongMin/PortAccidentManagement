package com.port.accident.portaccident.domain.code;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDetailedCode is a Querydsl query type for DetailedCode
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDetailedCode extends EntityPathBase<DetailedCode> {

    private static final long serialVersionUID = 1002758579L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDetailedCode detailedCode = new QDetailedCode("detailedCode");

    public final StringPath code = createString("code");

    public final StringPath comment = createString("comment");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final QRepresentativeCode representativeCode;

    public QDetailedCode(String variable) {
        this(DetailedCode.class, forVariable(variable), INITS);
    }

    public QDetailedCode(Path<? extends DetailedCode> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDetailedCode(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDetailedCode(PathMetadata metadata, PathInits inits) {
        this(DetailedCode.class, metadata, inits);
    }

    public QDetailedCode(Class<? extends DetailedCode> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.representativeCode = inits.isInitialized("representativeCode") ? new QRepresentativeCode(forProperty("representativeCode")) : null;
    }

}

