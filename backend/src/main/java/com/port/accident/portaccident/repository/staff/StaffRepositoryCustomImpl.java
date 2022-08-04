package com.port.accident.portaccident.repository.staff;

import com.port.accident.portaccident.domain.staff.Staff;
import com.port.accident.portaccident.dto.SearchCondition;
import com.port.accident.portaccident.dto.staff.StaffSearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<Staff> searchPageStaff(StaffSearchCondition condition, Pageable pageable) {
        List<Staff> content = queryFactory
                .selectFrom(staff)
                .where(
                        nameContains(condition.getName()),
                        corporationContains(condition.getCorporation())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(staff.count())
                .where(
                        nameContains(condition.getName()),
                        corporationContains(condition.getCorporation())
                )
                .from(staff);

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private BooleanExpression nameContains(String nameCond) {
        return isEmpty(nameCond) ? null : staff.name.contains(nameCond);
    }

    private BooleanExpression corporationContains(String corporationCond) {
        return isEmpty(corporationCond) ? null : staff.corporation.contains(corporationCond);
    }

    private Pageable pageableSetting(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작 -> 페이지에서 -1 처리

        return PageRequest.of(page, 10);
    }
}
