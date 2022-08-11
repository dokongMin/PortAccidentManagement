package com.port.accident.portaccident.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IncidentImpact {
    DAMAGE("단순"),
    SLIGHT("경상"),
    SERIOUS("중상"),
    DEATH("사망");

    private final String impactValue;
}
