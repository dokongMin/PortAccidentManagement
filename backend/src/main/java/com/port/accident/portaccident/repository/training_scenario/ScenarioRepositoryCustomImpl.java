package com.port.accident.portaccident.repository.training_scenario;

import com.port.accident.portaccident.dto.training_scenario.QScenarioAccidentPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioAccidentPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioSearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.port.accident.portaccident.domain.training_scenario.QScenario.scenario;
import static com.port.accident.portaccident.domain.training_scenario.elements.QAccidentPortFacility.accidentPortFacility;
import static com.port.accident.portaccident.domain.training_scenario.elements.QAccidentResponseActivity.accidentResponseActivity;
import static org.springframework.util.ObjectUtils.isEmpty;

@Repository
@Transactional
@RequiredArgsConstructor
public class ScenarioRepositoryCustomImpl implements ScenarioRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<ScenarioAccidentPortFacilityDto> searchPageScenario(ScenarioSearchCondition condition, Pageable pageable) {
        pageable = pageableSetting(pageable);

        List<ScenarioAccidentPortFacilityDto> content = queryFactory
                .select(new QScenarioAccidentPortFacilityDto(
                        scenario.id,
                        scenario.name,
                        scenario.incidentLevel,
                        scenario.incidentImpact,
                        scenario.incidentType,
                        scenario.incidentDetailType,
                        scenario.portArea))
                .from(scenario)
                .where(nameContains(condition.getName()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(scenario.count())
                .from(scenario)
                .where(nameContains(condition.getName()));

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private BooleanExpression nameContains(String nameCondition) {
        return isEmpty(nameCondition) ? null : scenario.name.contains(nameCondition);
    }

    private BooleanExpression managerContains(String managerCondition) {
        return isEmpty(managerCondition) ? null : accidentResponseActivity.manager.contains(managerCondition);
    }

    private Pageable pageableSetting(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);

        return PageRequest.of(page, 10);
    }
}
