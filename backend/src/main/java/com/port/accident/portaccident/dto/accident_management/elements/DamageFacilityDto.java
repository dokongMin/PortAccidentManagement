//package com.port.accident.portaccident.dto.accident_management.elements;
//
//import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
//import com.port.accident.portaccident.domain.accident_management.elements.DamageFacility;
//import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Getter
//@Setter
//public class DamageFacilityDto {
//    private String name;
//
//    private List<DamageFacilityInfo> damageFacilityInfoList = new ArrayList<>();
//
//    @Builder
//    public DamageFacilityDto(String name, List<DamageFacilityInfo> damageFacilityInfoList) {
//        this.name = name;
//        this.damageFacilityInfoList = damageFacilityInfoList;
//    }
//
//    public DamageFacility toEntity() {
//        return DamageFacility.builder()
//                .name(name)
//                .damageFacilityInfoList(damageFacilityInfoList)
//                .build();
//    }
//}
