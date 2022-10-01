package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.domain.staff.Staff;
import com.port.accident.portaccident.dto.staff.StaffDto;
import com.port.accident.portaccident.dto.staff.StaffSearchCondition;
import com.port.accident.portaccident.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/EmergencyContact")
public class StaffController {
    private final StaffService staffService;

    @GetMapping("/EC_Register_Page")
    public String registerStaffPage() {
        return "EmergencyContact/EC_Register";
    }

    @PostMapping("/EC_Register")
    public String registerStaff(@RequestBody StaffDto staffDto) {
        /*TODO::혜원 영주님 - 비상연락망 등록
         *DTO의 필드명과 동일하
         * 게 form의 name 설정 시 DTO에 연결됩니다.
         *(name, corporation, group, position, email, phoneNumber)
         * */
        StaffDto registerStaffDto = staffService.toServiceDto(staffDto);
        staffService.registerStaff(registerStaffDto);

        return "redirect:/EmergencyContact/EC_Check";
    }

    @GetMapping("/EC_Check")
    public String checkStaff(Model model,
                             @RequestParam(required = false, defaultValue = "") String name,
                             @RequestParam(required = false, defaultValue = "") String corporation,
                             @PageableDefault Pageable pageable) {

        /* TODO::혜원 영주님 - 비상연락망 조회
         * 이름과 회사명으로 검색 가능합니다.
         *
         * staff에는 id, name, corporation, group, position, email, phoneNumber 값이 있습니다.*/


        StaffSearchCondition condition = new StaffSearchCondition(name, corporation);
        Page<Staff> staffList = staffService.searchPageStaff(condition, pageable);

        model.addAttribute("condition", condition);
        model.addAttribute("staffList", staffList);
        return "EmergencyContact/EC_Check";
    }

}
