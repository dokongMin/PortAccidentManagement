package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.dto.accident_management.AccidentInfoDto;
import com.port.accident.portaccident.dto.accident_management.elements.CausesSafetyAccidentInfoDto;
import com.port.accident.portaccident.dto.accident_management.elements.DamageFacilityInfoDto;
import com.port.accident.portaccident.dto.accident_management.type.AccidentTypeDto;
import com.port.accident.portaccident.dto.accident_management.type.DisasterTypeDto;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/AccidentMangement")
public class AccidentManagementController {


    /**
     * 안전사고 정보 리스트 조회
     */
//    @GetMapping
//    public void getAccidentInfoList(){
//
//    }

    /**
     * 안전사고 등록
     */
    @PostMapping("/register")
    public void registerAccident(Model model, @ModelAttribute AccidentInfoDto accidentInfoDto){


    }

    /**
     * 안전사고 정보 개별 조회
     */
//    @GetMapping
//    public void getAccidentInfo(){
//
//    }

}
