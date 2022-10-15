package com.port.accident.portaccident.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.port.accident.portaccident.domain.code.DetailedCode;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.port.accident.portaccident.dto.code.*;
import com.port.accident.portaccident.repository.code.RepresentativeCodeRepository;
import com.port.accident.portaccident.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.CoderResult;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import static org.springframework.util.StringUtils.hasText;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Code")
public class CodeController {

    private final CodeService codeService;
    private final RepresentativeCodeRepository representativeCodeRepository;
    @GetMapping("/representativeCode_registerPage")
    public String repCodeRegiterPage() {
        return "CommonCode/RC_Register";
    }

    @RequestMapping("/representativeCode_register")
    public String registerRepCode(@RequestParam("code") String code,
                                  @RequestParam("name") String name) {
        codeService.createRepresentativeCode(new RepresentativeCode(code, name));

        return "redirect:/Code/representativeCode_list";   //저장이 완료되면 공통코드 조회 페이지로 이동
    }

    @GetMapping("/detailedCode_registerPage")
    public String detCodeRegiterPage(Model model) {
        List<RepresentativeCode> allReCodes = representativeCodeRepository.findAll();
        model.addAttribute("allReCodes", allReCodes);
        return "CommonCode/DC_Register";
    }

    @RequestMapping("/detailedCode_register")
    public String registerDetCode(@RequestBody DetailedCodeRegisterDto dto) {
        String code = dto.getCode();
        String name = dto.getName();
        String comment = dto.getComment();
        String representativeCodeName = dto.getRepCodeId();
        RepresentativeCode repCode = codeService.findByRepCode(representativeCodeName);
        Integer repCodeId = repCode.getId();
        codeService.createDetailedCode(new DetailedCode(code, name, comment), repCodeId);

        return "redirect:/Code/detailedCode_list";   //저장이 완료되면 상세코드 조회 페이지로 이동
    }




    @GetMapping("/representativeCode_list")
    public String repCodeListPage(Model model,
                                  @RequestParam(required = false, defaultValue = "") String code,
                                  @RequestParam(required = false, defaultValue = "") String name,
                                  @PageableDefault Pageable pageable) {
        CodeSearchCondition condition = new CodeSearchCondition(code, name);
        Page<RepresentativeCode> result = codeService.searchRepCodeListWithPaging(condition, pageable);
        model.addAttribute("condition", condition);
        model.addAttribute("detList", result);
        return "CommonCode/RC_Check";
    }

    @GetMapping("/detailedCode_list")
    public String detCodeListPage(Model model,
                                  @RequestParam(required = false, defaultValue = "") String code,
                                  @RequestParam(required = false, defaultValue = "") String name,
                                  @PageableDefault Pageable pageable) {
        CodeSearchCondition condition = new CodeSearchCondition(code, name);
        Page<DetRepJoinDto> result = codeService.searchDetCodeListWithPaging(condition, pageable);

        model.addAttribute("condition", condition);
        model.addAttribute("detList", result);
        return "CommonCode/DC_Check";
    }

    @RequestMapping(value = "/find_repCode", method = RequestMethod.POST)
    @ResponseBody
    public Object findRepCode(@RequestBody RepresentativeCodeDto dto) {
        RepresentativeCode result = null;

        Integer id = dto.getId();
        String code = dto.getCode();

        if (id != null) {
            result = codeService.findByRepCodeId(id);
        }
        if (hasText(code))
            result = codeService.findByRepCode(code);

        return result;
    }

    @RequestMapping(value = "/find_detCode", method = RequestMethod.POST)
    @ResponseBody
    public Object findDetCode(@RequestBody DetailedCodeDto dto) {
        DetailedCode result = null;

        Integer id = dto.getId();
        String code = dto.getCode();

        if (id != null) {
            result = codeService.findByDetCodeId(id);
        }
        if (hasText(code))
            result = codeService.findByDetCode(code);

        return result;
    }

    @GetMapping("/representativeCode_modifyPage")
    public String repCodeModifyPage(Model model) {
        return "CommonCode/RC_Modify";
    }

    @RequestMapping("/representativeCode_modify")
    public String modifyRepCode(@RequestBody RepresentativeCodeDto dto) {
        codeService.updateRepresentativeCode(dto.getId(), dto.getName());
        return "redirect:/Code/representativeCode_list";   //저장이 완료되면 공통코드 조회 페이지로 이동
    }

    @GetMapping("/detailedCode_modifyPage")
    public String detCodeModifyPage() {
        return "CommonCode/DC_Modify";
    }

    @RequestMapping("/detailedCode_modify")
    public String modifyDetCode(@RequestBody DetailedCodeDto dto) {
        codeService.updateDetailedCode(dto);

        return "redirect:/Code/representativeCode_list";   //저장이 완료되면 공통코드 조회 페이지로 이동
    }
}
