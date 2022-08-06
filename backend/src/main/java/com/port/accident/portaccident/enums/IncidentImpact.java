package com.port.accident.portaccident.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IncidentImpact {
    INCIDENT_IMPACT_A("단순"),
    INCIDENT_IMPACT_B("경상"),
    INCIDENT_IMPACT_C("중상"),
    INCIDENT_IMPACT_D("사망");

    private final String impactValue;
}
