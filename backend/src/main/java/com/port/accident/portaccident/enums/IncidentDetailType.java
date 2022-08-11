package com.port.accident.portaccident.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IncidentDetailType {
    DROP("추락"),
    FALL("넘어짐"),
    BUMP("부딪힘"),
    TRAP("끼임"),
    HIT("맞음");

    private final String typeValue;
}
