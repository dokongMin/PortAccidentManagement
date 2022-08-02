package com.port.accident.portaccident.domain.accident_management;

import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccident;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacility;
import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "accident_info")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToMany(mappedBy = "accidentInfo")
    private List<AccidentType> accidentTypeList = new ArrayList<>();

    @OneToMany(mappedBy = "accidentInfo")
    private List<CausesSafetyAccident> causesSafetyAccidentList = new ArrayList<>();

    @OneToMany(mappedBy = "accidentInfo")
    private List<DamageFacility> damageFacilityList = new ArrayList<>();

    @Builder
    public AccidentInfo(Integer id, LocalDateTime accidentDate, String accidentArea, String accidentLevel, String accidentImpact,
                        String accidentPath, String accidentManager, String victim, List<AccidentType> accidentTypeList,
                        List<CausesSafetyAccident> causesSafetyAccidentList, List<DamageFacility> damageFacilityList) {
        this.id = id;
        this.accidentDate = accidentDate;
        this.accidentArea = accidentArea;
        this.accidentLevel = accidentLevel;
        this.accidentImpact = accidentImpact;
        this.accidentPath = accidentPath;
        this.accidentManager = accidentManager;
        this.victim = victim;
        this.accidentTypeList = accidentTypeList;
        this.causesSafetyAccidentList = causesSafetyAccidentList;
        this.damageFacilityList = damageFacilityList;
    }
}
