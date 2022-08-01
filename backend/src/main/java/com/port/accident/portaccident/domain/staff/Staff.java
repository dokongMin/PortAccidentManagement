package com.port.accident.portaccident.domain.staff;

import com.port.accident.portaccident.domain.code.DetailedCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "staff")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Staff {

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

    @Builder
    public Staff(Integer id, String name, String corporation, String group, String position, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.corporation = corporation;
        this.group = group;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
