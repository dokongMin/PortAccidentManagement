package com.port.accident.portaccident.repository.code;

import com.port.accident.portaccident.domain.code.DetailedCode;
import com.port.accident.portaccident.domain.code.QDetailedCode;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.port.accident.portaccident.dto.code.CodeSearchCondition;
import com.port.accident.portaccident.dto.code.DetRepJoinDto;
import com.port.accident.portaccident.dto.code.QDetRepJoinDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.port.accident.portaccident.domain.code.QDetailedCode.detailedCode;
import static com.port.accident.portaccident.domain.code.QRepresentativeCode.representativeCode;
import static org.springframework.util.StringUtils.hasText;

public class CodeRepositoryCustomImpl implements CodeRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public CodeRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<RepresentativeCode> searchPageRepCode(CodeSearchCondition condition, Pageable pageable) {
        List<RepresentativeCode> content = queryFactory
                .selectFrom(representativeCode)
                .where(
                        codeEq(condition.getCode(), "rep"),
                        nameEq(condition.getName(), "rep")
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<RepresentativeCode> countQuery = queryFactory
                .selectFrom(representativeCode)
                .where(
                        codeEq(condition.getCode(), "rep"),
                        nameEq(condition.getName(), "rep")
                );
        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);

    }

    @Override
    public Page<DetRepJoinDto> searchPageDetCode(CodeSearchCondition condition, Pageable pageable) {
        List<DetRepJoinDto> content = queryFactory
                .select(new QDetRepJoinDto(
                        detailedCode.id.as("detId"),
                        detailedCode.name.as("detName"),
                        detailedCode.code.as("detCode"),
                        detailedCode.comment,
                        representativeCode.code.as("repCode")

                ))
                .from(detailedCode)
                .leftJoin(detailedCode.representativeCode, representativeCode)
                .where(
                        codeEq(condition.getCode(), "det"),
                        nameEq(condition.getName(), "det")
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<DetailedCode> countQuery = queryFactory
                .selectFrom(detailedCode)
                .leftJoin(detailedCode.representativeCode, representativeCode)
                .where(
                        codeEq(condition.getCode(), "det"),
                        nameEq(condition.getName(), "det")
                );
        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
    }

    private BooleanExpression nameEq(String name, String codeType) {
        return compareCondition(name, codeType, representativeCode.name, detailedCode.name);
    }

    private BooleanExpression codeEq(String code, String codeType) {
        return compareCondition(code, codeType, representativeCode.code, detailedCode.code);
    }

    private BooleanExpression compareCondition(String name, String codeType, StringPath name2, StringPath name3) {
        if (hasText(name)) {
            if (codeType.equals("rep"))
                return name2.eq(name);
            else if (codeType.equals("det"))
                return name3.eq(name);
        }
        return null;
    }

}
