package com.port.accident.portaccident.domain.accident_management.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CausesSafetyAccidentEnum {

    Fall("추락"),
    Hit("부딪힘");

    private final String value;
}
