package com.port.accident.portaccident.domain.code;

import lombok.Getter;

import javax.persistence.*;

@Table(name = "detailed_code")
@Entity
@Getter
public class DetailedCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailed_code_id")
    private Integer id;
    @Column(name = "detailed_code_name")
    private String name;
    @Column(name = "detailed_code_comment")
    private String comment;
}
