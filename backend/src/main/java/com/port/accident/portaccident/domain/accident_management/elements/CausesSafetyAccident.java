package com.port.accident.portaccident.domain.accident_management.elements;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "causes_safety_accident")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CausesSafetyAccident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "causes_safety_accident_id")
    private Integer id;

    @Column(name = "causes_safety_accident_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accident_info_id")
    private AccidentInfo accidentInfo;
}
