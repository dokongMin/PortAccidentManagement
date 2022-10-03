package com.port.accident.portaccident.domain.accident_management.type;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccidentTypeEnum {

    FallDown("추락"),
    TripOver("넘어짐"),
    Stuck("끼임"),
    Strike("맞음"),
    Hit("부딪힘");


    private final String value;
}
