package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.domain.training_scenario.scenario_evaluation.ScenarioEvaluation;
import com.port.accident.portaccident.dto.training_scenario.scenario_evaluation.ScenarioEvaluationDto;
import com.port.accident.portaccident.dto.training_scenario_result.EvaluationSearchCondition;
import com.port.accident.portaccident.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/TS_Assessment")
public class ScenarioEvaluationController {

    private final ScenarioService scenarioService;

    @RequestMapping("/TSA_Register")
    public String registerScenarioEvaluation(Model model,
                                             @RequestParam(required = false, defaultValue = "") String scenarioName,
                                             @RequestBody ScenarioEvaluationDto scenarioEvaluationDto) {

        ScenarioEvaluationDto registerScenarioEvaluationDto = scenarioService.toServiceScenarioEvaluation(scenarioEvaluationDto);
        scenarioService.registerScenarioEvaluation(scenarioName, registerScenarioEvaluationDto);

        model.addAttribute("scenarioName", scenarioName);

        return "TS_Assessment/TSA_Register";
    }

    @RequestMapping("/TSA_Modify")
    public String modifyScenarioEvaluation(@RequestBody ScenarioEvaluationDto scenarioEvaluationDto) {
        ScenarioEvaluationDto modifyScenarioEvaluationDto = scenarioService.toServiceScenarioEvaluation(scenarioEvaluationDto);
        scenarioService.modifyScenarioEvaluation(modifyScenarioEvaluationDto);

        return "TS_Assessment/TSA_Modify";
    }

    @RequestMapping("/TSA_Check")
    public String selectScenarioEvaluation(Model model,
                                           @RequestParam(required = false, defaultValue = "") String name,
                                           @PageableDefault Pageable pageable) {

        EvaluationSearchCondition condition = new EvaluationSearchCondition(name);
        Page<ScenarioEvaluation> evaluation = scenarioService.searchPageScenarioEvaluation(condition, pageable);

        model.addAttribute("condition", condition);
        model.addAttribute("evaluation", evaluation);
        return "TS_Assessment/TSA_Check";
    }

}
