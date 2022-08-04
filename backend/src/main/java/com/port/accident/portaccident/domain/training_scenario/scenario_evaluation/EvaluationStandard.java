package com.port.accident.portaccident.domain.training_scenario.scenario_evaluation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum EvaluationStandard {
    DEVELOPMENT("발전가능성", Arrays.asList("사고원인 발생 가능 여부", "사고결과 발생 가능 여부")),
    POSSIBLE("적절성", Arrays.asList("계획시간 배치", "사고 대응 로직 구성")),
    COMPLETE("완전성", Arrays.asList("관련 설비 포함 여부", "사고대응 설비 포함 여부"));

    private final String standard;
    private final List<String> detailsStandard;
}
