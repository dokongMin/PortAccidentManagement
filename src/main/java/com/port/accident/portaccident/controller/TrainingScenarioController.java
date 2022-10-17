package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.domain.training_scenario.elements.AccidentResponseActivity;
import com.port.accident.portaccident.dto.training_scenario.ScenarioAccidentPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioSearchCondition;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentResponseActivityDto;
import com.port.accident.portaccident.enums.*;
import com.port.accident.portaccident.repository.training_scenario.ScenarioRepository;
import com.port.accident.portaccident.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static org.springframework.util.StringUtils.hasText;

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

    @GetMapping("/TS_Register_Page")
    public String registerTrainingScenarioPage() {
        return "TrainingScenarios/TS_Register";
    }

    @PostMapping("/TS_Register")
    public String registerTrainingScenario(@RequestBody ScenarioAccidentPortFacilityDto scenarioAccidentPortFacilityDto) {
        /*TODO::혜원 현정님 - 시나리오 등록
         * DTO의 필드명과 동일하게 form의 name 설정 시 DTO에 연결됩니다.
         * (name, incidentLevel, incidentImpact, incidentType, incidentDetailType, portArea)
         *
         * 항만설비의 경우 체크 박스의 모든 name을 facilityList로 설정 시 List에 연결됩니다.
         *
         * name을 제외한 필드는 모두 enum으로 처리해주세요!
         * */

        ScenarioDto registerScenarioDto = scenarioService.toServiceScenarioDto(scenarioAccidentPortFacilityDto);
        List<AccidentPortFacilityDto> registerFacilityDtoList = scenarioService.makeAccidentPortFacilityDtoBuilder(scenarioAccidentPortFacilityDto.getAccidentPortFacilityList());

        scenarioService.registerScenario(registerScenarioDto, registerFacilityDtoList);
//        scenarioService.saveScenario(registerScenarioDto);
        return "redirect:/TrainingScenarios/TS_Check";
    }

    @GetMapping("/TS_Modify_Page")
    public String modifyTrainingScenarioPage(Model model, @RequestParam("scenarioId") Integer scenarioId) {
        Scenario scenario = scenarioService.findById(scenarioId);
        List<PortFacility> portFacilityNameList = scenarioService.findAccidentPortFacilityNameByScenarioId(scenarioId);
        List<AccidentResponseActivity> accidentResponseActivityList = scenarioService.findAccidentResponseActivityByScenarioId(scenarioId);

        model.addAttribute("scenario", scenario);
        model.addAttribute("portFacilityList", portFacilityNameList);
        model.addAttribute("accidentResponseActivityList", accidentResponseActivityList);

        return "TrainingScenarios/TS_Modify";
    }

    @RequestMapping("/TS_Modify")
    public String modifyTrainingScenario(@RequestBody ScenarioAccidentPortFacilityDto scenarioAccidentPortFacilityDto) {

        /*TODO:: 혜원 현정님 - 시나리오 수정
         * 수정 시에는 시나리오의 id도 함께 넘겨주세요 (필드명: id)*/

        ScenarioDto modifyScenarioDto = scenarioService.toServiceScenarioDto(scenarioAccidentPortFacilityDto);
        List<AccidentPortFacilityDto> modifyFacilityDtoList = scenarioService.makeAccidentPortFacilityDtoBuilder(scenarioAccidentPortFacilityDto.getAccidentPortFacilityList());

//        AccidentResponseActivityDto modifyAccidentResponseActivityDto = scenarioService.toServiceAccidentResponseActivity(accidentResponseActivityDto);
//        scenarioService.updateAccidentResponseActivity(modifyAccidentResponseActivityDto);

        scenarioService.modifyScenario(modifyScenarioDto, modifyFacilityDtoList);

        return "redirect:/TrainingScenarios/TS_Check";
    }

    @PostMapping("/TS_Modify_Check")
    public String modifyCheck(@RequestParam(value = "nameCheck") String nameCheck) throws Exception {
        Scenario scenario = scenarioRepository.findByName(nameCheck).orElseThrow(() -> new Exception("해당 시나리오명은 없습니다."));
        return "TrainingScenarios/TS_Modify";
    }


//    @GetMapping("/TS_Check_Page")
//    public String checkTrainingScenario(){
//        return "TrainingScenarios/TS_Check";
//    }

    @RequestMapping("/TS_Check")
    public String checkTrainingScenario(Model model,
                                        @RequestParam(required = false, defaultValue = "") String name,
                                        @RequestParam(required = false, defaultValue = "") String incidentLevel,
                                        @RequestParam(required = false, defaultValue = "") String incidentType,
                                        @RequestParam(required = false, defaultValue = "") String incidentDetailType,
                                        @PageableDefault Pageable pageable) {

        /*TODO::혜원 현정님 - 시나리오 조회
         * 대응 활동이 분리되었기 때문에 매니저명으로 검색이 제외되어야 할 것 같아
         * 시나리오 명으로만 검색 가능하도록 변경하였습니다.
         *
         * scenario에는 id, name, incidentLevel, incidentImpact, incidentType, incidentDetailType, portArea 값이 있습니다.*/

        ScenarioSearchCondition condition = new ScenarioSearchCondition();
        if (hasText(name))
            condition.setName(name);
        if (hasText(incidentLevel))
            condition.setIncidentLevel(IncidentLevel.valueOf(incidentLevel));
        if (hasText(incidentType))
            condition.setIncidentType(IncidentType.valueOf(incidentType));
        if (hasText(incidentDetailType))
            condition.setIncidentDetailType(IncidentDetailType.valueOf(incidentDetailType));

        Page<ScenarioAccidentPortFacilityDto> scenarios = scenarioService.searchPageScenario(condition, pageable);

        model.addAttribute("condition", condition);
        model.addAttribute("scenarios", scenarios);
        return "TrainingScenarios/TS_Check";
    }


    @RequestMapping("/TS_Detail/{scenarioId}")
    public String detailTrainingScenario(Model model, @PathVariable(value = "scenarioId") Integer scenarioId) {

        /* TODO::혜원 현정님 - 시나리오 상세 조회
         * 시나리오 아이디로 시나리오 사고 항만 설비와 사고 대응활동을 조회하였습니다.
         * 사고 항만설비와 사고 대응활동은 여러 개 존재 가능합니다
         * (디테일 페이지에서 등록된 모든 사고 대응활동 조회 가능)
         *
         * scenario에는 id, name, incidentLevel, incidentImpact, incidentType, incidentDetailType, portArea 값이 있습니다.
         * accidentResponseActivity에는 id, comment, manager, completePlaningTime가 있습니다.
         * portFacilityNameList에는 PortFacility값이 있습니다.
         **/
        Scenario scenario = scenarioService.findById(scenarioId);

        List<PortFacility> portFacilityNameList = scenarioService.findAccidentPortFacilityNameByScenarioId(scenarioId);
        List<AccidentResponseActivity> accidentResponseActivityList = scenarioService.findAccidentResponseActivityByScenarioId(scenarioId);

        model.addAttribute("scenario", scenario);
        model.addAttribute("portFacilityList", portFacilityNameList);
        model.addAttribute("accidentResponseActivityList", accidentResponseActivityList);

        return "TrainingScenarios/TS_Detail";
    }


    @GetMapping("/ARA_Register_Page/{scenarioId}")
    public String registerAccidentResponseActivityPage(Model model, @PathVariable(value = "scenarioId") Integer scenarioId) {
        String scenarioName = scenarioService.findNameById(scenarioId);

        model.addAttribute("scenarioId", scenarioId);
        model.addAttribute("scenarioName", scenarioName);
        return "TrainingScenarios/AccidentResponseActivity/ARA_Register";
    }

    @PostMapping("/ARA_Register")
    public String registerAccidentResponseActivity(RedirectAttributes redirectAttributes,
                                                   @RequestBody AccidentResponseActivityDto accidentResponseActivityDto) {
        /* TODO::혜원 현정님 - 안전사고대응활동 등록
         * DTO의 필드명과 동일하게 form의 name 설정 시 DTO에 연결됩니다.
         * (id, comment, manager, completePlaningTime)
         *
         * 시나리오 디테일 페이지에서 안전사고대응활동을 등록할 수 있는 버튼을 누르면 이동합니다.
         * */

        AccidentResponseActivityDto registerAccidentResponseActivityDto = scenarioService.toServiceAccidentResponseActivity(accidentResponseActivityDto);
        scenarioService.registerAccidentResponseActivity(accidentResponseActivityDto.getScenarioId(), registerAccidentResponseActivityDto);

        redirectAttributes.addAttribute("scenarioId", accidentResponseActivityDto.getScenarioId());

        return "redirect:/TrainingScenarios/TS_Detail/{scenarioId}";
    }

    @GetMapping("/ARA_Modify_Page")
    public String modifyAccidentResponseActivityPage(Model model,
                                                     @RequestParam("accidentResponseActivityId") Integer accidentResponseActivityId) {
        AccidentResponseActivity accidentResponseActivity = scenarioService.findByAccidentResponseActivityId(accidentResponseActivityId);

        model.addAttribute("accidentResponseActivity", accidentResponseActivity);

        return "TrainingScenarios/ARA_Modify";
    }

    @RequestMapping("/ARA_Modify")
    public String modifyAccidentResponseActivity(RedirectAttributes redirectAttributes,
                                                 @RequestBody AccidentResponseActivityDto accidentResponseActivityDto) {

        /*TODO:: 혜원 현정님 - 안전사고대응활동 수정*/

        AccidentResponseActivityDto modifyAccidentResponseActivityDto = scenarioService.toServiceAccidentResponseActivity(accidentResponseActivityDto);
        scenarioService.updateAccidentResponseActivity(modifyAccidentResponseActivityDto);

        redirectAttributes.addAttribute("scenarioId", modifyAccidentResponseActivityDto.getScenario().getId());

        return "redirect:/TrainingScenarios//TS_Detail/{scenarioId}";
    }
}