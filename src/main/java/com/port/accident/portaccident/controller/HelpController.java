package com.port.accident.portaccident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/help")
public class HelpController {

    @GetMapping("/stateaccident")
    public String graphAccidentPage(){
        return "/help/stateaccident";
    }
}
