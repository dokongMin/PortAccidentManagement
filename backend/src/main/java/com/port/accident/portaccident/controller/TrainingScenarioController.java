package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.dto.training_scenario.ScenarioAccidentPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioSearchCondition;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
import com.port.accident.portaccident.enums.PortFacility;
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

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/TrainingScenarios")
public class TrainingScenarioController {

    private final ScenarioService scenarioService;

    @RequestMapping("/TS_Register")
    public String registerTrainingScenario(@RequestBody ScenarioDto scenarioDto,
                                           @RequestParam List<PortFacility> facilityList) {

        ScenarioDto registerScenarioDto = scenarioService.toServiceScenarioDto(scenarioDto);

        List<AccidentPortFacilityDto> facilityDtoList = scenarioService.makeAccidentPortFacilityDtoBuilder(facilityList);
        List<AccidentPortFacilityDto> registerFacilityDtoList = scenarioService.toServiceAccidentPortFacilityDtoList(facilityDtoList);

        scenarioService.registerScenario(registerScenarioDto, registerFacilityDtoList);

        return "TrainingScenarios/TS_Register";
    }


    @RequestMapping("/TS_Modify")
    public String modifyTrainingScenario(@RequestBody ScenarioDto scenarioDto,
                                         @RequestBody List<AccidentPortFacilityDto> facilityDtoList) {

        ScenarioDto modifyScenarioDto = scenarioService.toServiceScenarioDto(scenarioDto);
        List<AccidentPortFacilityDto> modifyFacilityDtoList = scenarioService.toServiceAccidentPortFacilityDtoList(facilityDtoList);
        scenarioService.modifyScenario(modifyScenarioDto, modifyFacilityDtoList);

        return "TrainingScenarios/TS_Modify";
    }

    @RequestMapping("/staff_list")
    public String checkTrainingScenario(Model model,
                                        @RequestParam(required = false, defaultValue = "") String name,
                                        @PageableDefault Pageable pageable) {

        ScenarioSearchCondition condition = new ScenarioSearchCondition(name);
        Page<ScenarioAccidentPortFacilityDto> scenario = scenarioService.searchPageScenario(condition, pageable);

        model.addAttribute("condition", condition);
        model.addAttribute("scenario", scenario);
        return "TrainingScenarios/TS_Check";
    }

}
