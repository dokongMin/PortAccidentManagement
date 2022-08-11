package com.port.accident.portaccident.dto.accident_management;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo;
import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import com.port.accident.portaccident.domain.accident_management.type.DisasterType;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class AccidentInfoDto {
    private LocalDate accidentDate;
    private String accidentArea;
    private String accidentLevel;
    private String accidentImpact;
    private String accidentInspect;
    private String accidentManager;
    private String victim;

    private String incidentType;
    private AccidentType accidentType;

    private DisasterType disasterType;

    private List<CausesSafetyAccidentInfo> causesSafetyAccidentInfoList = new ArrayList<>();

    private List<DamageFacilityInfo> damageFacilityInfoList = new ArrayList<>();

    @Builder
    public AccidentInfoDto(LocalDate accidentDate, String accidentArea, String accidentLevel, String accidentImpact, String accidentInspect,
                           String accidentManager, String victim,String incidentType, AccidentType accidentType, DisasterType disasterType,
                           List<CausesSafetyAccidentInfo> causesSafetyAccidentInfoList, List<DamageFacilityInfo> damageFacilityInfoList) {
        this.accidentDate = accidentDate;
        this.accidentArea = accidentArea;
        this.accidentLevel = accidentLevel;
        this.accidentImpact = accidentImpact;
        this.accidentInspect = accidentInspect;
        this.accidentManager = accidentManager;
        this.victim = victim;
        this.incidentType = incidentType;
        this.accidentType = accidentType;
        this.disasterType = disasterType;
        this.causesSafetyAccidentInfoList = causesSafetyAccidentInfoList;
        this.damageFacilityInfoList = damageFacilityInfoList;
    }


    public AccidentInfo toEntity() {
        return AccidentInfo.builder()
                .accidentDate(accidentDate)
                .accidentArea(accidentArea)
                .accidentLevel(accidentLevel)
                .accidentImpact(accidentImpact)
                .accidentInspect(accidentInspect)
                .accidentManager(accidentManager)
                .victim(victim)
                .incidentType(incidentType)
                .accidentType(accidentType)
                .disasterType(disasterType)
                .causesSafetyAccidentInfoList(causesSafetyAccidentInfoList)
                .damageFacilityInfoList(damageFacilityInfoList)
                .build();
    }

}
