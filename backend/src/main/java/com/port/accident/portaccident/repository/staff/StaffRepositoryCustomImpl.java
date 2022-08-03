package com.port.accident.portaccident.repository.staff;

import com.port.accident.portaccident.domain.staff.Staff;
import com.port.accident.portaccident.dto.SearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.port.accident.portaccident.domain.staff.QStaff.staff;
import static org.springframework.util.ObjectUtils.isEmpty;

@Repository
@Transactional
@RequiredArgsConstructor
public class StaffRepositoryCustomImpl implements StaffRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Staff> searchPage(SearchCondition condition, Pageable pageable) {
        List<Staff> content = queryFactory
                .selectFrom(staff)
                .where(keywordContains(condition.getType(), condition.getKeyword()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(staff.count())
                .where(keywordContains(condition.getType(), condition.getKeyword()))
                .from(staff);

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }


    private BooleanExpression keywordContains(String type, String keyword) {
        if (type == null)
            return null;

        switch (type) {
            case "name":
                return nameContains(keyword);

            case "corporation":
                return corporationContains(keyword);

            case "group":
                return groupContains(keyword);

            case "position":
                return positionContains(keyword);

            default:
                return null;
        }
    }

    private BooleanExpression nameContains(String nameCond) {
        return isEmpty(nameCond) ? null : staff.name.contains(nameCond);
    }

    private BooleanExpression corporationContains(String corporationCond) {
        return isEmpty(corporationCond) ? null : staff.corporation.contains(corporationCond);
    }

    private BooleanExpression groupContains(String groupCond) {
        return isEmpty(groupCond) ? null : staff.group.contains(groupCond);
    }

    private BooleanExpression positionContains(String positionCond) {
        return isEmpty(positionCond) ? null : staff.position.contains(positionCond);
    }
}
