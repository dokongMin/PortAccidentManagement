package com.port.accident.portaccident.domain.accident_management;

import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo;
import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import com.port.accident.portaccident.domain.accident_management.type.DisasterType;
import com.port.accident.portaccident.dto.accident_management.AccidentInfoDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate accidentDate;

    @Column(name = "accident_area")
    private String accidentArea;

    @Column(name = "accident_level")
    private String accidentLevel;

    @Column(name = "accident_impact")
    private String accidentImpact;

    @Column(name = "accident_inspect")
    private String accidentInspect;

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
    public AccidentInfo(Integer id, LocalDate accidentDate, String accidentArea, String accidentLevel, String accidentImpact,
                        String accidentInspect, String accidentManager, String victim, AccidentType accidentType, DisasterType disasterType,
                        List<CausesSafetyAccidentInfo> causesSafetyAccidentInfoList, List<DamageFacilityInfo> damageFacilityInfoList) {
        this.id = id;
        this.accidentDate = accidentDate;
        this.accidentArea = accidentArea;
        this.accidentLevel = accidentLevel;
        this.accidentImpact = accidentImpact;
        this.accidentInspect = accidentInspect;
        this.accidentManager = accidentManager;
        this.victim = victim;
        this.accidentType = accidentType;
        this.disasterType = disasterType;
        this.causesSafetyAccidentInfoList = causesSafetyAccidentInfoList;
        this.damageFacilityInfoList = damageFacilityInfoList;

//        if(this.accidentType != null){
//            accidentType.getAccidentInfoList().remove(this);
//        }
//        this.accidentType = accidentType;
//        accidentType.getAccidentInfoList().add(this);

//        if(this.disasterType != null){
//            disasterType.getAccidentInfoList().remove(this);
//        }
//        disasterType.getAccidentInfoList().add(this);
    }
    public void update(AccidentInfoDto dto){
        this.accidentDate = dto.getAccidentDate();
        this.accidentArea = dto.getAccidentArea();
        this.accidentLevel = dto.getAccidentLevel();
        this.accidentImpact = dto.getAccidentImpact();
        this.accidentInspect = dto.getAccidentInspect();
        this.accidentManager = dto.getAccidentManager();
        this.victim = dto.getVictim();
        this.accidentType = dto.getAccidentType();
        this.disasterType = dto.getDisasterType();
        this.causesSafetyAccidentInfoList = dto.getCausesSafetyAccidentInfoList();
        this.damageFacilityInfoList = dto.getDamageFacilityInfoList();
    }


}
