package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo;
import com.port.accident.portaccident.domain.accident_management.type.AccidentType;
import com.port.accident.portaccident.dto.accident_management.AccidentInfoDto;
import com.port.accident.portaccident.dto.accident_management.elements.CausesSafetyAccidentInfoDto;
import com.port.accident.portaccident.dto.accident_management.elements.DamageFacilityInfoDto;
import com.port.accident.portaccident.dto.accident_management.type.AccidentTypeDto;
import com.port.accident.portaccident.dto.accident_management.type.DisasterTypeDto;
import com.port.accident.portaccident.repository.accident_management.AccidentManagementRepository;
import com.port.accident.portaccident.repository.accident_management.AccidentTypeRepository;
import com.port.accident.portaccident.service.accident_management_service.AccidentManagementService;
import com.port.accident.portaccident.service.accident_management_service.AccidentTypeService;
import com.port.accident.portaccident.service.accident_management_service.CausesSafetyAccidentService;
import com.port.accident.portaccident.service.accident_management_service.DamageFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/SafetyAccident")
public class AccidentManagementController {


    private final AccidentManagementService accidentManagementService;
    private final AccidentManagementRepository accidentManagementRepository;
    private final AccidentTypeRepository accidentTypeRepository;
    private final AccidentTypeService accidentTypeService;
    private final CausesSafetyAccidentService causesSafetyAccidentService;

    private final DamageFacilityService damageFacilityService;

    /**
     * 안전사고 등록
     */

    @GetMapping("/SA_registration")
    public void registerAccident() {
    }

    @PostMapping("/SA_registration")
    public String registerAccident(Model model, @RequestParam("accidentType") String accidentType, @RequestParam("damageFacilityInfoList") List<String> damageFacilityInfoList,
                                 @RequestParam("causesSafetyAccidentInfoList") List<String> causesSafetyAccidentInfoList, @RequestParam("accidentLevel") String accidentLevel,
                                 @RequestParam("accidentImpact") String accidentImpact, @RequestParam("accidentArea") String accidentArea,
                                 @RequestParam("accidentManager") String accidentManager, @RequestParam("accidentInspect") String accidentInspect,
                                 @RequestParam("victim") String victim, @RequestParam("accidentDate") String accidentDate,
                                 @RequestParam("incidentType") String incidentType) throws Exception
    {
        AccidentTypeDto accidentTypeBuild = AccidentTypeDto.builder()
                .name(accidentType)
                .build();
        Integer accidentTypeId = accidentTypeService.saveAccidentType(accidentTypeBuild);
        AccidentType accidentTypeDto = accidentTypeRepository.findById(accidentTypeId).orElseThrow(() -> new Exception("해당 사고 유형이 존재하지 않습니다."));

        LocalDate parseDate = LocalDate.parse(accidentDate, DateTimeFormatter.ISO_DATE);
        AccidentInfoDto dto = AccidentInfoDto.builder()
                .accidentDate(parseDate)
                .accidentArea(accidentArea)
                .accidentLevel(accidentLevel)
                .accidentImpact(accidentImpact)
                .accidentInspect(accidentInspect)
                .accidentManager(accidentManager)
                .victim(victim)
                .incidentType(incidentType)
                .accidentType(accidentTypeDto)
                .build();
        Integer accidentInfoId = accidentManagementService.saveAccidentInfo(dto);
        AccidentInfo accidentInfos = accidentManagementRepository.findById(accidentInfoId).orElseThrow(() -> new Exception("해당 사고는 존재하지 않습니다."));

        for (String damageFacility : damageFacilityInfoList) {
            DamageFacilityInfoDto damageBuild = DamageFacilityInfoDto.builder()
                    .name(damageFacility)
                    .accidentInfo(accidentInfos)
                    .build();
            damageFacilityService.saveDamageFacilityInfo(damageBuild);
        }

        for (String causesSafety : causesSafetyAccidentInfoList) {
            CausesSafetyAccidentInfoDto causesBuild = CausesSafetyAccidentInfoDto.builder()
                    .name(causesSafety)
                    .accidentInfo(accidentInfos)
                    .build();
            causesSafetyAccidentService.saveCausesSafetyAccidentInfo(causesBuild);
        }
        return "/SafetyAccident/SA_check";
    }

    /**
     * 안전사고 정보 리스트 조회 페이징 & 검색
     */
    @GetMapping("/SA_check")
    public String getAccidentInfoList(Model model, @PageableDefault(size = 2) Pageable pageable,
                                      @RequestParam(required = false, defaultValue = "") String searchText){
        Page<AccidentInfo> accidents = accidentManagementRepository.findByAccidentInspectContaining(searchText, pageable);
        int startPage = Math.max(1, accidents.getPageable().getPageNumber() - 1);
        int endPage = Math.min(accidents.getTotalPages(), accidents.getPageable().getPageNumber() + 3);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("accidents", accidents);
        return "/SafetyAccident/SA_check";
    }

    /**
     * 안전사고 정보 개별 조회
     */
//    @GetMapping
//    public void getAccidentInfo(){
//
//    }

}
