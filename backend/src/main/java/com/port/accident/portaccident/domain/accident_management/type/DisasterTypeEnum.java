package com.port.accident.portaccident.domain.accident_management.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DisasterTypeEnum {

    EarthQuake("지진"),
    Typhoon("태풍"),
    ShipAccident("선박사고");



    private final String value;
}
