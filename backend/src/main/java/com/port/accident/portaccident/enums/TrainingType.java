package com.port.accident.portaccident.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TrainingType {
    VIRTUAL("도상 훈련"),
    ACTUAL("실전 훈련");

    private final String typeValue;
}
