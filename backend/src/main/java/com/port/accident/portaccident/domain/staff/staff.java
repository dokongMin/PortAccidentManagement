package com.port.accident.portaccident.domain.staff;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "staff")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer id;

    @Column(name = "staff_name")
    private String name;

    @Column(name = "staff_co")
    private String corporation;

    @Column(name = "staff_group")
    private String group;

    @Column(name = "staff_position")
    private String position;

    @Column(name = "staff_email")
    private String email;

    @Column(name = "staff_phone")
    private String phoneNumber;
}
