package com.port.accident.portaccident.domain.accident_management.elements;


import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "cuases_safety_accident_info")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CausesSafetyAccidentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "causes_safety_accident_info_id")
    private Integer id;

    @Column(name = "causes_safety_accident_info_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accident_info_id")
    private AccidentInfo accidentInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "causes_safety_accident_id")
    private CausesSafetyAccident causesSafetyAccident;

    @Builder
    public CausesSafetyAccidentInfo(Integer id, String name, AccidentInfo accidentInfo, CausesSafetyAccident causesSafetyAccident) {
        this.id = id;
        this.name = name;
        this.accidentInfo = accidentInfo;
        this.causesSafetyAccident = causesSafetyAccident;
    }
}
