package com.port.accident.portaccident.domain.accident_management;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "accident_info")
@Entity
@Getter
public class AccidentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_info_id")
    private Integer id;

    @Column(name = "accident_date")
    private LocalDateTime accidentDate;

    @Column(name = "accident_area")
    private String accidentArea;

    @Column(name = "accident_level")
    private String accidentLevel;

    @Column(name = "accident_impact")
    private String accidentImpact;

    @Column(name = "accident_path")
    private String accidentPath;

    @Column(name = "accident_manager")
    private String accidentManager;

    @Column(name = "victim")
    private String victim;
}
