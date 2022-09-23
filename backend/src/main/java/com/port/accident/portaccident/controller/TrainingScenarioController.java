package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.dto.training_scenario.ScenarioAccidentPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioSearchCondition;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
import com.port.accident.portaccident.enums.PortFacility;
import com.port.accident.portaccident.repository.training_scenario.ScenarioRepository;
import com.port.accident.portaccident.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/TrainingScenarios")
public class TrainingScenarioController {

    private final ScenarioService scenarioService;
    private final ScenarioRepository scenarioRepository;

    /*TODO::혜원 현정님 - 시나리오
    * 1개의 시나리오에 여러 대응 활동이 작성되야하므로 화면 수정이 필요합니다.
    * (시나리오 등록 페이지와 대응 활동 등록 페이지 분리)
    *
    * 시나리오 목록 조회 페이지 또한 대응 활동과 매니저명이 제외되어야 합니다.*/

    @GetMapping("/TS_Check")
    public String checkTrainingScenario(){
        return "TrainingScenarios/TS_Check";
    }
    @GetMapping("/TS_Register_Page")
    public String registerTrainingScenarioPage() {
        return "TrainingScenarios/TS_Register";
    }

    @PostMapping("/TS_Register")
    public String registerTrainingScenario(@RequestBody ScenarioDto scenarioDto) {
        /*TODO::혜원 현정님 - 시나리오 등록
        * DTO의 필드명과 동일하게 form의 name 설정 시 DTO에 연결됩니다.
        * (name, incidentLevel, incidentImpact, incidentType, incidentDetailType, portArea)
        *
        * 항만설비의 경우 체크 박스의 모든 name을 facilityList로 설정 시 List에 연결됩니다.
        *
        * name을 제외한 필드는 모두 enum으로 처리해주세요!
        * */

        ScenarioDto registerScenarioDto = scenarioService.toServiceScenarioDto(scenarioDto);

//        List<AccidentPortFacilityDto> facilityDtoList = scenarioService.makeAccidentPortFacilityDtoBuilder(facilityList);
//        List<AccidentPortFacilityDto> registerFacilityDtoList = scenarioService.toServiceAccidentPortFacilityDtoList(facilityDtoList);
//
//        scenarioService.registerScenario(registerScenarioDto, registerFacilityDtoList);
        scenarioService.saveScenario(registerScenarioDto);
        return "redirect:/TrainingScenarios/TS_Check";
    }

    @GetMapping("/TS_Modify_Page")
    public String modifyTrainingScenarioPage() {
        return "TrainingScenarios/TS_Modify";
    }

    @RequestMapping("/TS_Modify")
    public String modifyTrainingScenario(@RequestBody ScenarioDto scenarioDto,
                                         @RequestParam List<PortFacility> facilityList) {

        /*TODO:: 혜원 현정님 - 시나리오 수정
        * 수정 시에는 시나리오의 id도 함께 넘겨주세요 (필드명: id)*/

        ScenarioDto modifyScenarioDto = scenarioService.toServiceScenarioDto(scenarioDto);

        List<AccidentPortFacilityDto> facilityDtoList = scenarioService.makeAccidentPortFacilityDtoBuilder(facilityList);
        List<AccidentPortFacilityDto> modifyFacilityDtoList = scenarioService.toServiceAccidentPortFacilityDtoList(facilityDtoList);
        scenarioService.modifyScenario(modifyScenarioDto, modifyFacilityDtoList);

        return "redirect:/TrainingScenarios/TS_Check";
    }

    @RequestMapping("/staff_list")
    public String checkTrainingScenario(Model model,
                                        @RequestParam(required = false, defaultValue = "") String name,
                                        @PageableDefault Pageable pageable) {

        /*TODO::혜원 현정님 - 시나리오 조회
        * 대응 활동이 분리되었기 때문에 매니저명으로 검색이 제외되어야 할 것 같아
        * 시나리오 명으로만 검색 가능하도록 변경하였습니다.
        *
        * scenario에는 id, name, incidentLevel, incidentImpact, incidentType, incidentDetailType, portArea 값이 있습니다.*/

        ScenarioSearchCondition condition = new ScenarioSearchCondition(name);
        Page<ScenarioAccidentPortFacilityDto> scenario = scenarioService.searchPageScenario(condition, pageable);

        model.addAttribute("condition", condition);
        model.addAttribute("scenario", scenario);
        return "TrainingScenarios/TS_Check";
    }

}
