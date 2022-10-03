package com.port.accident.portaccident.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IncidentType {
    INCIDENT("사고"), DISASTER("재난");

    private final String typeValue;
}
