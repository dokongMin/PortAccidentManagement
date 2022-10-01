package com.port.accident.portaccident.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IncidentLevel {
    LEVEL_1("Level1"), LEVEL_2("Level2"), LEVEL_3("Level3");

    private final String levelValue;
}
