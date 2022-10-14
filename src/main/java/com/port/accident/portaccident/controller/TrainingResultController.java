package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultCondition;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultDto;
import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultJoinScenarioDto;
import com.port.accident.portaccident.enums.*;
import com.port.accident.portaccident.repository.training_scenario.ScenarioRepository;
import com.port.accident.portaccident.repository.training_scenario_result.TrainingResultRepository;
import com.port.accident.portaccident.service.TrainingResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.util.StringUtils.hasText;

@Controller
@RequiredArgsConstructor
@RequestMapping("/TrainingResult")
public class TrainingResultController {
    private final TrainingResultService resultService;
    private final TrainingResultRepository resultRepository;
    private final ScenarioRepository scenarioRepository;

    @GetMapping("/trainingResult_registerPage")
    public String trainingResultRegisterPage(Model model) {
        List<Scenario> allScenarios = scenarioRepository.findAll();
        model.addAttribute("allScenarios", allScenarios);
        return "TrainingResult/TR_registration";
    }

    @GetMapping("/trainingResult_detail/{resultId}")
    public String trainingResultDetail(Model model, @PathVariable(value = "resultId") Integer resultId) {
        return "TrainingResult/TR_detail";
    }

    @RequestMapping(value = "/trainingResult_register", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public String registerTrainingResult(@RequestBody Map<String, Object> param) {
        //TODO::태영 영주님
        /* 아래의 JSON코드 형식 참고하셔서 프론트에서 JSON 만드시면 됩니다! */
        /* JSON example
        {
            "TrainingResult": {
                "name" : "name",
                "place":"PLACE1",
                "startDate":"2022-07-24T22:00:00.000Z",
                "endDate":"2022-07-30T22:00:00.000Z",
                "trainingType" : "VIRTUAL",
                "incidentLevel" : "LEVEL_1",
                "incidentImpact" : "INCIDENT_IMPACT_A",
                "department":"안전관리부서"
                .... (생략)
            },
            "TrainingPortFacilitys": [
                "CONTAINER", "FORKLIFT", "LADDER"
            ],
            "TrainingParticipants":[
                1,2,3,4,5
            ]
        }
        */
        resultService.createTrainingResultUsingJsonString(param);
        return "redirect:/TrainingResult/trainingResult_list";      //데이터 저장하면 바로 조회페이지로 이동
    }

    @GetMapping("/trainingResult_daysPage")
    public String trainingResultDetailByDays(Model model)
    {
        List<Scenario> scenarioList = scenarioRepository.findAll();
        List<TrainingResult> resultList = resultRepository.findAll();

        model.addAttribute("scenarioList", scenarioList);
        model.addAttribute("resultList", resultList);
        return "TrainingResult/TR_days";
    }

    @RequestMapping(value = "/trainingResult_days", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public String registerTrainingResultDetailByDays(@RequestBody List<Map<String, Object>> param) {
        //TODO::태영 영주님
        /* 아래의 JSON코드 형식 참고하셔서 프론트에서 JSON 만드시면 됩니다! */
        /* JSON example
        [
            {
                "trainingResultId" : 1
            },
            {
                "details" : "detail-ex1",
                "completionCheck":"COMPLETE",
                "evaluationName":"evaluationName-ex1"
            },
            {
                "name": "evaluation_details_name1",
                "score": 5
            },
            {
                "name": "evaluation_details_name2",
                "score": 4
            },
            {
                "name": "evaluation_details_name3",
                "score": 3
            }
        ]
        */
        resultService.createEvaluationDetailsByDays(param);

        return "redirect:/TrainingResult/trainingResult_list";      //데이터 저장하면 바로 조회페이지로 이동
    }

    @GetMapping("/trainingResult_list")
    public String trainingResultList(Model model,
                                     @RequestParam(required = false, defaultValue = "") String incidentType,
                                     @RequestParam(required = false, defaultValue = "") String name,
                                     @RequestParam(required = false, defaultValue = "") String incidentLevel,
                                     @RequestParam(required = false, defaultValue = "") String incidentDetailType,
                                     @RequestParam(required = false, defaultValue = "") String department,
                                     @PageableDefault Pageable pageable) {

        TrainingResultCondition condition = new TrainingResultCondition(name, incidentDetailType, department);
        if (hasText(incidentType))
            condition.setIncidentType(IncidentType.valueOf(incidentType));
        if(hasText(incidentLevel))
            condition.setIncidentLevel(IncidentLevel.valueOf(incidentLevel));
        Page<TrainingResultJoinScenarioDto> result = resultService.searchTrainingResultListWithPaging(condition, pageable);
        model.addAttribute("condition", condition);
        model.addAttribute("trList", result);

        return "TrainingResult/TR_check";
    }

    @GetMapping("/trainingResult_modifyPage")
    public String trainingResultModifyPage(@RequestParam("trainingResultId") Integer trainingResultId, Model model) {
        TrainingResult result = resultService.findByTrainingResultId(trainingResultId);
        model.addAttribute("trainingResult",result);
        return "TrainingResult/TR_modify";
    }

    @RequestMapping(value = "/trainingResult_modify", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public String updateTrainingResult(@RequestBody Map<String, Object> param) {
        //TODO::태영 영주님
        /* 아래의 JSON코드 형식 참고하셔서 프론트에서 JSON 만드시면 됩니다! */
        /* JSON example - registerTrainingResult()에서 TrainingResult.id만 추가됨
        {
            "TrainingResult": {
                "id" : 1,
                "name" : "name",
                "place":"PLACE1",
                "startDate":"2022-07-24T22:00:00.000Z",
                "endDate":"2022-07-30T22:00:00.000Z",
                "trainingType" : "VIRTUAL",
                "incidentLevel" : "LEVEL_1",
                "incidentImpact" : "INCIDENT_IMPACT_A",
                "department":"안전관리부서"
                .... (생략)
            },
            "TrainingPortFacilitys": [
                "CONTAINER", "FORKLIFT", "LADDER"
            ],
            "TrainingParticipants":[
                1,2,3,4,5
            ]
        }
        */

        resultService.updateTrainingResultUsingJsonString(param);

        return "redirect:/TrainingResult/trainingResult_list";      //데이터 저장하면 바로 조회페이지로 이동
    }
}
