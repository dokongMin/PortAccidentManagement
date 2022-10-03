package com.port.accident.portaccident.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TrainingPlace {
    PLACE1("무역항 수상구역"),
    PLACE2("무역항 육상구역"),
    PLACE3("연안항 수상구역"),
    PLACE4("연안항 육상구역"),
    PLACE5("하역");

    private final String placeValue;
}
