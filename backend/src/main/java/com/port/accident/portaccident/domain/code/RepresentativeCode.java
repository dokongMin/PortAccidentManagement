package com.port.accident.portaccident.domain.code;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "representative_code")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RepresentativeCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "representative_code_id")
    private Integer id;

    @Column(name = "representative_code_name")
    private String name;

    @Column(name = "representative_code_comment")
    private String comment;

    @OneToMany(mappedBy = "representative_code")
    private List<DetailedCode> detailedCode = new ArrayList<>();
}
