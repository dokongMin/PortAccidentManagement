//package com.port.accident.portaccident.domain.accident_management.elements;
//
//import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Table(name = "causes_safety_accident")
//@Entity
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class CausesSafetyAccident {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "causes_safety_accident_id")
//    private Integer id;
//
//    @Column(name = "causes_safety_accident_name")
//    private String name;
//
//
//    @OneToMany(mappedBy = "causesSafetyAccident")
//    private List<CausesSafetyAccidentInfo> causesSafetyAccidentInfoList = new ArrayList<>();
//
//    @Builder
//    public CausesSafetyAccident(Integer id, String name, List<CausesSafetyAccidentInfo> causesSafetyAccidentInfoList) {
//        this.id = id;
//        this.name = name;
//        this.causesSafetyAccidentInfoList = causesSafetyAccidentInfoList;
//    }
//}
