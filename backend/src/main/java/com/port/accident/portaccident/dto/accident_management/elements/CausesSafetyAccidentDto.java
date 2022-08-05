//package com.port.accident.portaccident.dto.accident_management.elements;
//
//
//import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
//import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccident;
//import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentInfo;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Getter
//@Setter
//public class CausesSafetyAccidentDto {
//    private String name;
//    private List<CausesSafetyAccidentInfo> causesSafetyAccidentInfoList = new ArrayList<>();
//
//
//    @Builder
//    public CausesSafetyAccidentDto(String name, List<CausesSafetyAccidentInfo> causesSafetyAccidentInfoList) {
//        this.name = name;
//        this.causesSafetyAccidentInfoList = causesSafetyAccidentInfoList;
//    }
//
//    public CausesSafetyAccident toEntity() {
//        return CausesSafetyAccident.builder()
//                .name(name)
//                .causesSafetyAccidentInfoList(causesSafetyAccidentInfoList)
//                .build();
//    }
//}
