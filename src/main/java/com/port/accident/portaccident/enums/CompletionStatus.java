package com.port.accident.portaccident.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CompletionStatus {

    A("적합"),
    B("미흡"),
    C("부적합");

    private final String statusValue;
}
