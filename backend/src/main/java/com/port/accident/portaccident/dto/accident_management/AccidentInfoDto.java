package com.port.accident.portaccident.dto.accident_management;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccident;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacility;
import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class AccidentInfoDto {
    private LocalDateTime accidentDate;
    private String accidentArea;
    private String accidentLevel;
    private String accidentImpact;
    private String accidentPath;
    private String accidentManager;
    private String victim;
    private List<AccidentType> accidentTypeList = new ArrayList<>();
    private List<CausesSafetyAccident> causesSafetyAccidentList = new ArrayList<>();
    private List<DamageFacility> damageFacilityList = new ArrayList<>();

    @Builder
    public AccidentInfoDto(LocalDateTime accidentDate, String accidentArea, String accidentLevel, String accidentImpact,
                           String accidentPath, String accidentManager, String victim, List<AccidentType> accidentTypeList,
                           List<CausesSafetyAccident> causesSafetyAccidentList, List<DamageFacility> damageFacilityList) {
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

    public AccidentInfo toEntity() {
        return AccidentInfo.builder()
                .accidentDate(accidentDate)
                .accidentArea(accidentArea)
                .accidentLevel(accidentLevel)
                .accidentImpact(accidentImpact)
                .accidentPath(accidentPath)
                .accidentManager(accidentManager)
                .victim(victim)
                .accidentTypeList(accidentTypeList)
                .causesSafetyAccidentList(causesSafetyAccidentList)
                .damageFacilityList(damageFacilityList)
                .build();
    }

}
