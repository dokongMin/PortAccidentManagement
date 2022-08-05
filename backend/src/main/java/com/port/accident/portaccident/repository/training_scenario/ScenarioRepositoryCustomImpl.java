package com.port.accident.portaccident.repository.training_scenario;

import com.port.accident.portaccident.dto.training_scenario.QScenarioAccidentResponseActivityDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioAccidentResponseActivityDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioSearchCondition;
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
import static com.port.accident.portaccident.domain.training_scenario.elements.QAccidentResponseActivity.accidentResponseActivity;
import static org.springframework.util.ObjectUtils.isEmpty;

@Repository
@Transactional
@RequiredArgsConstructor
public class ScenarioRepositoryCustomImpl implements ScenarioRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<ScenarioAccidentResponseActivityDto> searchPageScenario(ScenarioSearchCondition condition, Pageable pageable) {
        List<ScenarioAccidentResponseActivityDto> content = queryFactory
                .select(new QScenarioAccidentResponseActivityDto(
                        scenario.name,
                        scenario.incidentImpact,
                        scenario.incidentType,
                        scenario.incidentDetailType,
                        accidentResponseActivity.incidentLevel,
                        accidentResponseActivity.comment,
                        accidentResponseActivity.manager))
                .from(scenario)
                .leftJoin(scenario.accidentResponseActivityList, accidentResponseActivity)
                .where(
                        nameContains(condition.getName()),
                        managerContains(condition.getManager())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(scenario.count())
                .from(scenario)
                .leftJoin(scenario.accidentResponseActivityList, accidentResponseActivity)
                .where(
                        nameContains(condition.getName()),
                        managerContains(condition.getManager())
                );

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private BooleanExpression nameContains(String nameCondition) {
        return isEmpty(nameCondition) ? null : scenario.name.contains(nameCondition);
    }

    private BooleanExpression managerContains(String managerCondition) {
        return isEmpty(managerCondition) ? null : accidentResponseActivity.manager.contains(managerCondition);
    }
}
