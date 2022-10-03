package com.port.accident.portaccident.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuitableCheck {
    Y(true),
    N(false);

    private final boolean checkValue;

}
