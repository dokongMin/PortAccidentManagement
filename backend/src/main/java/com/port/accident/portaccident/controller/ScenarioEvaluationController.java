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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/TS_Assessment")
public class ScenarioEvaluationController {

    private final ScenarioService scenarioService;

    @GetMapping("/TSA_Register_Page")
    public String registerScenarioEvaluationPage() {
        return "TS_Assessment/TSA_Register";
    }

    @RequestMapping("/TSA_Register")
    public String registerScenarioEvaluation(Model model,
                                             @RequestParam(required = false, defaultValue = "") String scenarioName,
                                             @RequestBody ScenarioEvaluationDto scenarioEvaluationDto) {

        /* TODO::혜원 현정님 - 시나리오 평가 등록
         * 평가를 등록할 시나리오명을 scenarioName으로 넘겨주세요!
         *
         * DTO의 필드명과 동일하게 form의 name 설정 시 DTO에 연결됩니다.
         * (name, developmentStandard1, developmentStandard2, possibleStandard1, possibleStandard2, completeStandard1, completeStandard2)
         *
         * 발생 가능성(사고원인 발생 가능 여부, 사고결과 발생 가능 여부),
         * 적절성 (계획시간 배치, 사고 대응 로직 구성),
         * 완전성(관련 설비 포함 여부, 사고대응 설비 포함 여부) 순서입니다.
         *
         * name(시나리오 평가명)을 제외한 필드는 모두 enum으로 처리해주세요!
         * */

        ScenarioEvaluationDto registerScenarioEvaluationDto = scenarioService.toServiceScenarioEvaluation(scenarioEvaluationDto);
        scenarioService.registerScenarioEvaluation(scenarioName, registerScenarioEvaluationDto);

        model.addAttribute("scenarioName", scenarioName);

        return "redirect:/TS_Assessment/TSA_Check";
    }

    @GetMapping("/TSA_Modify_Page")
    public String modifyScenarioEvaluationPage() {
        return "TS_Assessment/TSA_Modify";
    }


    @RequestMapping("/TSA_Modify")
    public String modifyScenarioEvaluation(@RequestBody ScenarioEvaluationDto scenarioEvaluationDto) {
        /* TODO:: 혜원 현정님 - 시나리오 평가 수정
         * 수정 시에는 시나리오 평가의 id도 함께 넘겨주세요 (필드명: id)*/

        ScenarioEvaluationDto modifyScenarioEvaluationDto = scenarioService.toServiceScenarioEvaluation(scenarioEvaluationDto);
        scenarioService.modifyScenarioEvaluation(modifyScenarioEvaluationDto);

        return "redirect:/TS_Assessment/TSA_Check";
    }


    @RequestMapping("/TSA_Check")
    public String selectScenarioEvaluation(Model model,
                                           @RequestParam(required = false, defaultValue = "") String name,
                                           @PageableDefault Pageable pageable) {

        /* TODO:: 혜원 현정님 - 시나리오 평가 조회
         * 시나리오 평가명으로 검색할 수 있습니다.
         *
         * evaluation에는 id, name, developmentStandard1, developmentStandard2, possibleStandard1, possibleStandard2,
         * completeStandard1, completeStandard2 값이 있습니다.*/

        EvaluationSearchCondition condition = new EvaluationSearchCondition(name);
        Page<ScenarioEvaluation> evaluation = scenarioService.searchPageScenarioEvaluation(condition, pageable);

        model.addAttribute("condition", condition);
        model.addAttribute("evaluation", evaluation);
        return "TS_Assessment/TSA_Check";
    }

}
