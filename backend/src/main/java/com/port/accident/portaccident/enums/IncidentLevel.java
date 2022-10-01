package com.port.accident.portaccident.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IncidentLevel {
    LEVEL_1("1"), LEVEL_2("2"), LEVEL_3("3");

    private final String levelValue;
}
