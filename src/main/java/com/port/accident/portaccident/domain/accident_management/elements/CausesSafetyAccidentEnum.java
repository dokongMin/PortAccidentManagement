package com.port.accident.portaccident.domain.accident_management.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CausesSafetyAccidentEnum {

    Carelessness("추락"),
    WeakSafetyManagement("안전관리 부주의"),
    WeakFacility("부실 시설");


    private final String value;
}
