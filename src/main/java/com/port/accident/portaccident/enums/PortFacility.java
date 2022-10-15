package com.port.accident.portaccident.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PortFacility {
    CRANE("크레인"),
    CONTAINER("컨테이너"),
    FORKLIFT("지게차"),
    LADDER("사다리");

    private final String facilityValue;
}
