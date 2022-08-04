package com.port.accident.portaccident.domain.accident_management;

import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccident;
import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacility;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo;
import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import com.port.accident.portaccident.domain.accident_management.type.DisasterType;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accident_type_id")
    private AccidentType accidentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disaster_type_id")
    private DisasterType disasterType;

    @OneToMany(mappedBy = "accidentInfo")
    private List<CausesSafetyAccidentInfo> causesSafetyAccidentInfoList = new ArrayList<>();

    @OneToMany(mappedBy = "accidentInfo")
    private List<DamageFacilityInfo> damageFacilityInfoList = new ArrayList<>();

    @Builder
    public AccidentInfo(Integer id, LocalDateTime accidentDate, String accidentArea, String accidentLevel, String accidentImpact,
                        String accidentPath, String accidentManager, String victim, AccidentType accidentType, DisasterType disasterType,
                        List<CausesSafetyAccidentInfo> causesSafetyAccidentInfoList, List<DamageFacilityInfo> damageFacilityInfoList) {
        this.id = id;
        this.accidentDate = accidentDate;
        this.accidentArea = accidentArea;
        this.accidentLevel = accidentLevel;
        this.accidentImpact = accidentImpact;
        this.accidentPath = accidentPath;
        this.accidentManager = accidentManager;
        this.victim = victim;
        this.accidentType = accidentType;
        this.disasterType = disasterType;
        this.causesSafetyAccidentInfoList = causesSafetyAccidentInfoList;
        this.damageFacilityInfoList = damageFacilityInfoList;
    }
}
