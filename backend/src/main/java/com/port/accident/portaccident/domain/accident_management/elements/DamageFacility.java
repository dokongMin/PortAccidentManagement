package com.port.accident.portaccident.domain.accident_management.elements;


import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accident_info_id")
    private AccidentInfo accidentInfo;

    @Builder
    public DamageFacility(Integer id, String name, AccidentInfo accidentInfo) {
        this.id = id;
        this.name = name;
        this.accidentInfo = accidentInfo;
    }
}
