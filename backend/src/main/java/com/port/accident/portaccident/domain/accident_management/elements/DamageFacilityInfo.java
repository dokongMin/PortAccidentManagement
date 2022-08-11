package com.port.accident.portaccident.domain.accident_management.elements;


import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "damage_facility_info")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DamageFacilityInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "damage_facility_info_id")
    private Integer id;

    @Column(name = "damage_facility_info_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accident_info_id")
    private AccidentInfo accidentInfo;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "damage_facility_id")
//    private DamageFacility damageFacility;

    @Enumerated(EnumType.STRING)
    private DamageFacilityEnum damageFacilityEnum;

    @Builder
    public DamageFacilityInfo(Integer id, String name, AccidentInfo accidentInfo, DamageFacilityEnum damageFacilityEnum) {
        this.id = id;
        this.name = name;
        this.accidentInfo = accidentInfo;
        this.damageFacilityEnum = damageFacilityEnum;
    }

}
