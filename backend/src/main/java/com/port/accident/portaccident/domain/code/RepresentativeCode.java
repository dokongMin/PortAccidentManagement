package com.port.accident.portaccident.domain.code;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "representative_code")
@Getter
public class RepresentativeCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "representative_code_id")
    private Integer id;

    @Column(name = "representative_code_name")
    private String name;

    @Column(name = "representative_code_comment")
    private String comment;
}
