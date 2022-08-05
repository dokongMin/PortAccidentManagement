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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/EmergencyContact")
public class StaffController {
    private final StaffService staffService;

    @RequestMapping("/EC_registration")
    public String registerStaff(@RequestBody StaffDto staffDto) {
        StaffDto registerStaffDto = staffService.toServiceDto(staffDto);
        staffService.registerStaff(registerStaffDto);

        return "EmergencyContact/EC_registration";
    }

    @RequestMapping("/EC_check")
    public String checkStaff(Model model,
                             @RequestParam(required = false, defaultValue = "") String name,
                             @RequestParam(required = false, defaultValue = "") String corporation,
                             @PageableDefault Pageable pageable) {

        StaffSearchCondition condition = new StaffSearchCondition(name, corporation);
        Page<Staff> staff = staffService.searchPageStaff(condition, pageable);

        model.addAttribute("condition", condition);
        model.addAttribute("staff", staff);
        return "EmergencyContact/EC_check";
    }

}
