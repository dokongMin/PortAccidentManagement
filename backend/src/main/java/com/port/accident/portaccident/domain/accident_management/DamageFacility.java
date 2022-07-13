package com.port.accident.portaccident.domain.accident_management;


import lombok.Getter;

import javax.persistence.*;

@Table(name = "damage_facility")
@Entity
@Getter
public class DamageFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "damage_facility_id")
    private Integer id;

    @Column(name = "damage_facility_name")
    private String name;
}
