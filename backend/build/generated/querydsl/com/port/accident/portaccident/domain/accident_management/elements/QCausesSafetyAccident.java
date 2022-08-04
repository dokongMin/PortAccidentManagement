package com.port.accident.portaccident.domain.accident_management.elements;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCausesSafetyAccident is a Querydsl query type for CausesSafetyAccident
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCausesSafetyAccident extends EntityPathBase<CausesSafetyAccident> {

    private static final long serialVersionUID = 1921442748L;

    public static final QCausesSafetyAccident causesSafetyAccident = new QCausesSafetyAccident("causesSafetyAccident");

    public final ListPath<CausesSafetyAccidentInfo, QCausesSafetyAccidentInfo> causesSafetyAccidentInfoList = this.<CausesSafetyAccidentInfo, QCausesSafetyAccidentInfo>createList("causesSafetyAccidentInfoList", CausesSafetyAccidentInfo.class, QCausesSafetyAccidentInfo.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QCausesSafetyAccident(String variable) {
        super(CausesSafetyAccident.class, forVariable(variable));
    }

    public QCausesSafetyAccident(Path<? extends CausesSafetyAccident> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCausesSafetyAccident(PathMetadata metadata) {
        super(CausesSafetyAccident.class, metadata);
    }

}

