package com.port.accident.portaccident.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CompletionStatus {
    NOT_COMPLETE(false),
    COMPLETE(true);

    private final boolean statusValue;
}
