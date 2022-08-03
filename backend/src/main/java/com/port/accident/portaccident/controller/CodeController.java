package com.port.accident.portaccident.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.port.accident.portaccident.domain.code.DetailedCode;
import com.port.accident.portaccident.domain.code.RepresentativeCode;
import com.port.accident.portaccident.dto.code.CodeSearchCondition;
import com.port.accident.portaccident.dto.code.DetRepJoinDto;
import com.port.accident.portaccident.dto.code.RepresentativeCodeDto;
import com.port.accident.portaccident.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import static org.springframework.util.StringUtils.hasText;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Code")
public class CodeController {

    private final CodeService codeService;

    @GetMapping("/representativeCode_registerPage")
    public String repCodeRegiterPage() {
        return "CommonCode/RC_Register";
    }

    @RequestMapping("/representativeCode_register")
    public String registerRepCode(@RequestParam("code") String code,
                                  @RequestParam("name") String name) {
        //TODO::태영 현정님
        /* form형식으로 동작한다고 가정하고 작성한 코드이므로
         * 화면상에서 js를 이용해 null값 제한을 걸어줘야 함 */
        codeService.createRepresentativeCode(new RepresentativeCode(code, name));

        return "redirect:/Code/representativeCode_list";   //저장이 완료되면 공통코드 조회 페이지로 이동
    }

    @GetMapping("/detailedCode_registerPage")
    public String detCodeRegiterPage() {
        return "CommonCode/DC_Register";
    }

    @RequestMapping("/detailedCode_register")
    public String registerDetCode(@RequestParam("code") String code,
                                  @RequestParam("name") String name) {
        //TODO::태영 현정님
        /* form형식으로 동작한다고 가정하고 작성한 코드이므로
         * 화면상에서 js를 이용해 null값 제한을 걸어줘야 함 */
        codeService.createDetailedCode(new DetailedCode(code, name));

        return "redirect:/Code/detailedCode_list";   //저장이 완료되면 상세코드 조회 페이지로 이동
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

    @RequestMapping(value = "/find_repCode", method = RequestMethod.POST)
    @ResponseBody
    public Object findRepCode(@RequestBody RepresentativeCodeDto dto) {
        //TODO::태영 현정님
        /* 단일 값을 가져와야 하므로 유니크 제약조건이 없는 name조건은 제거 */
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

    @GetMapping("/representativeCode_modifyPage")
    public String repCodeModifyPage(Model model) {
        return "CommonCode/RC_Modify";
    }

    @RequestMapping("/representativeCode_modify")
    public String modifyRepCode(@RequestBody RepresentativeCodeDto dto) {
        //TODO::태영 현정님
        /* 데이터 무결성을 위해 대표코드명만 변경 가능하도록 작성 */
        codeService.updateRepresentativeCode(dto.getId(), dto.getName());
        return "redirect:/Code/representativeCode_list";   //저장이 완료되면 공통코드 조회 페이지로 이동
    }
}
