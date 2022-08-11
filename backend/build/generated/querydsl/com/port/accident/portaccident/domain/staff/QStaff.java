package com.port.accident.portaccident.domain.staff;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStaff is a Querydsl query type for Staff
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStaff extends EntityPathBase<Staff> {

    private static final long serialVersionUID = 1922645607L;

    public static final QStaff staff = new QStaff("staff");

    public final StringPath corporation = createString("corporation");

    public final StringPath email = createString("email");

    public final StringPath group = createString("group");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath position = createString("position");

    public QStaff(String variable) {
        super(Staff.class, forVariable(variable));
    }

    public QStaff(Path<? extends Staff> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStaff(PathMetadata metadata) {
        super(Staff.class, metadata);
    }

}

