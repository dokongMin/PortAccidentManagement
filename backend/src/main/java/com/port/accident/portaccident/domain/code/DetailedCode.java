package com.port.accident.portaccident.domain.code;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "detailed_code")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DetailedCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailed_code_id")
    private Integer id;
    @Column(name = "detailed_code_name")
    private String name;
    @Column(name = "detailed_code_comment")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "representative_code_id")
    private RepresentativeCode representativeCode;
}
