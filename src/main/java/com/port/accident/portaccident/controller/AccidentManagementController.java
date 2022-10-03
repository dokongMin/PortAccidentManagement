package com.port.accident.portaccident.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccidentManagementController {


    /**
     * 안전사고 정보 리스트 조회
     */
    @GetMapping
    public void getAccidentInfoList(){

    }

    /**
     * 안전사고 등록
     */
    @PostMapping
    public void registerAccident(){

    }

    /**
     * 안전사고 정보 개별 조회
     */
    @GetMapping
    public void getAccidentInfo(){

    }

}
