package com.port.accident.portaccident.domain.accident_management;

import lombok.Getter;

import javax.persistence.*;

@Table(name = "causes_safety_accident")
@Entity
@Getter
public class CausesSafetyAccident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "causes_safety_accident_id")
    private Integer id;

    @Column(name = "causes_safety_accident_name")
    private String name;
}
