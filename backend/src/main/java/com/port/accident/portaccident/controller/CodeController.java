package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.port.accident.portaccident.dto.code.CodeSearchCondition;
import com.port.accident.portaccident.dto.code.DetRepJoinDto;
import com.port.accident.portaccident.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Code")
public class CodeController {

    private final CodeService codeService;

    @GetMapping("/representativeCode_register")
    public String repCodeRegiterPage() {
        return "CommonCode/RC_Register";
    }

    @GetMapping("/representativeCode_modify")
    public String repCodeModifyPage(Model model) {
        return "CommonCode/RC_Modify";
    }

    @GetMapping("/detailedCode_register")
    public String detCodeRegiterPage() {
        return "CommonCode/DC_Register";
    }

    @GetMapping("/detailedCode_modify")
    public String detCodeModifyPage() {
        return "CommonCode/DC_Modify";
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
}
