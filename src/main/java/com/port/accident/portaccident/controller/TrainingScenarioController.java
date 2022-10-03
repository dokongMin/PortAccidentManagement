package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/TrainingScenario")
public class TrainingScenarioController {

    private final ScenarioService scenarioService;

}
