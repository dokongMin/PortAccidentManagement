package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultDto;
import com.port.accident.portaccident.dto.training_scenario_result.elements.TrainingPortFacilityDto;
import com.port.accident.portaccident.enums.*;
import com.port.accident.portaccident.service.TrainingResultService;
import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/TrainingResult")
public class TrainingResultController {
    private final TrainingResultService resultService;

    @GetMapping("/trainingResult_registerPage")
    public String trainingResultRegisterPage() {
        return "TrainingResult/TR_registration";
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
            },
            "TrainingPortFacilitys": [
                "CONTAINER", "FORKLIFT", "LADDER"
            ],
            "TrainingParticipants":[
                1,2,3,4,5
            ]
        }
        */
        /* return example
          param.get("TrainingResult")           :   {name=name, place=PLACE1, trainingType=VIRTUAL, incidentLevel=LEVEL_1, incidentImpact=INCIDENT_IMPACT_A, department=안전관리부서}
          param.get("TrainingPortFacilitys")    :   [CONTAINER, FORKLIFT, LADDER]
          param.get("TrainingParticipants")     :   [1, 2, 3, 4, 5]
        */
        resultService.createTrainingResultUsingJsonString(param);

        return "redirect:/TrainingResult/trainingResult_list";      //데이터 저장하면 바로 조회페이지로 이동
    }

    @GetMapping("/trainingResult_modifyPage")
    public String trainingResultModifyPage() {
        return "TrainingResult/TR_modify";
    }

    @GetMapping("/trainingResult_daysPage")
    public String trainingResultDetailByDays() {
        return "TrainingResult/TR_days";
    }

    @GetMapping("/trainingResult_list")
    public String trainingResultList() {
        return "TrainingResult/TR_check";
    }
}
