package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.service.TrainingResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/TrainingResult")
public class TrainingResultController {
    private final TrainingResultService resultService;

//    @GetMapping("")
}
