package com.port.accident.portaccident.repository.training_scenario_result;

import com.port.accident.portaccident.domain.training_scenario.QScenario;
import com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult;
import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.dto.training_scenario_result.QTrainingResultJoinScenarioDto;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultCondition;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultDto;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultJoinScenarioDto;
import com.port.accident.portaccident.enums.IncidentLevel;
import com.port.accident.portaccident.enums.IncidentType;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.port.accident.portaccident.domain.training_scenario.QScenario.scenario;
import static com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult.trainingResult;
import static org.springframework.util.StringUtils.hasText;

public class TrainingResultRepositoryCustomImpl implements TrainingResultRepositoryCustom {

    private JPAQueryFactory queryFactory;

    public TrainingResultRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<TrainingResultJoinScenarioDto> searchPageTrainingResults(TrainingResultCondition condition, Pageable pageable) {
        List<TrainingResultJoinScenarioDto> content = queryFactory.select(new QTrainingResultJoinScenarioDto(
                scenario.id.as("scenarioId"),
                scenario.name.as("scenarioName"),
                trainingResult.id.as("trainingResultId"),
                trainingResult.name.as("trainingName"),
                trainingResult.incidentLevel,
                trainingResult.incidentDetailType,
                trainingResult.place,
                trainingResult.department,
                trainingResult.trainingArea
        ))
                .from(trainingResult)
                .leftJoin(trainingResult.scenario, scenario)
                .where(
                        incidentTypeEq(condition.getIncidentType()),
                        trainingNameEq(condition.getName()),
                        incidentLevelEq(condition.getIncidentLevel()),
                        incidentDetailTypeEq(condition.getIncidentDetailType()),
                        departmentEq(condition.getDepartment())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<TrainingResult> countQuery = queryFactory
                .selectFrom(trainingResult)
                .leftJoin(trainingResult.scenario, scenario)
                .where(
                        incidentTypeEq(condition.getIncidentType()),
                        trainingNameEq(condition.getName()),
                        incidentLevelEq(condition.getIncidentLevel()),
                        incidentDetailTypeEq(condition.getIncidentDetailType()),
                        departmentEq(condition.getDepartment())

                );

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);

    }

    private BooleanExpression incidentTypeEq(IncidentType incidentType) {
        return incidentType != null ? trainingResult.incidentType.eq(incidentType) : null;

    }

    private BooleanExpression trainingNameEq(String name) {
        return hasText(name) ? trainingResult.name.eq(name) : null;
    }

    private BooleanExpression incidentLevelEq(IncidentLevel incidentLevel) {
        return incidentLevel != null ? trainingResult.incidentLevel.eq(incidentLevel) : null;
    }

    private BooleanExpression incidentDetailTypeEq(String incidentDetailType) {
        return hasText(incidentDetailType) ? trainingResult.incidentDetailType.eq(incidentDetailType) : null;
    }

    private BooleanExpression departmentEq(String department) {
        return hasText(department) ? trainingResult.department.eq(department) : null;
    }
}
