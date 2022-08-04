package com.port.accident.portaccident.repository.training_scenario_result;

import com.port.accident.portaccident.domain.training_scenario.QScenario;
import com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult;
import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.dto.training_scenario_result.QTrainingResultJoinScenarioDto;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultCondition;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultDto;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultJoinScenarioDto;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.port.accident.portaccident.domain.training_scenario.QScenario.scenario;
import static com.port.accident.portaccident.domain.training_scenario_result.QTrainingResult.trainingResult;

public class TrainingResultRepositoryCustomImpl implements TrainingResultRepositoryCustom {

    private JPAQueryFactory queryFactory;

    public TrainingResultRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    /*
    *  this.scenarioId = scenarioId;
            this.scenarioName = scenarioName;
            this.trainingResultId = trainingResultId;
            this.trainingName = trainingName;
            this.incidentLevel = incidentLevel;
            this.incidentDetailType = incidentDetailType;
            this.place = place;
            this.department = department;
            this.trainingArea = trainingArea;
    * */
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
                        /*검색조건*/
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<TrainingResult> countQuery = queryFactory
                .selectFrom(trainingResult)
                .leftJoin(trainingResult.scenario, scenario)
                .where(
                        /*검색조건*/
                );

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);

    }
}
