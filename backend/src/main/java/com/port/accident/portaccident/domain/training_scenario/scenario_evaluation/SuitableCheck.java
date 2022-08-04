package com.port.accident.portaccident.domain.training_scenario.scenario_evaluation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuitableCheck {
    Y(true),
    N(false);

    private final boolean checkValue;

}
