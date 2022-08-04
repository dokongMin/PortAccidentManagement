package com.port.accident.portaccident.repository.training_scenario;

import com.port.accident.portaccident.domain.staff.Staff;
import com.port.accident.portaccident.domain.training_scenario.Scenario;
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

import static com.port.accident.portaccident.domain.training_scenario.QScenario.scenario;
import static org.springframework.util.ObjectUtils.isEmpty;

@Repository
@Transactional
@RequiredArgsConstructor
public class ScenarioRepositoryCustomImpl implements ScenarioRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Scenario> searchPage(String nameCondition, Pageable pageable) {
        List<Scenario> content = queryFactory
                .selectFrom(scenario)
                .where(nameContains(nameCondition))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(scenario.count())
                .where(nameContains(nameCondition))
                .from(scenario);

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private BooleanExpression nameContains(String nameCondition) {
        if (nameCondition == null)
            return null;

        return isEmpty(nameCondition) ? null : scenario.name.contains(nameCondition);
    }
}
