package com.port.accident.portaccident.domain.accident_management.elements;


import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "damage_facility")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DamageFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "damage_facility_id")
    private Integer id;

    @Column(name = "damage_facility_name")
    private String name;

    @OneToMany(mappedBy = "damageFacility")
    private List<DamageFacilityInfo> damageFacilityInfoList = new ArrayList<>();


    @Builder
    public DamageFacility(Integer id, String name, List<DamageFacilityInfo> damageFacilityInfoList) {
        this.id = id;
        this.name = name;
        this.damageFacilityInfoList = damageFacilityInfoList;
    }
}
