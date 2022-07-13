package com.port.accident.portaccident.domain.accident_management;

import lombok.Getter;

import javax.persistence.*;

@Table(name = "accident_type")
@Entity
@Getter
public class AccidentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_type_id")
    private Integer id;

    @Column(name = "accident_type_name")
    private String name;
}
