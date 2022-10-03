package com.port.accident.portaccident.controller;

import com.port.accident.portaccident.dto.staff.StaffDto;
import com.port.accident.portaccident.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;

    @RequestMapping("/staff_register")
    public String registerStaff(@RequestBody StaffDto staffDto) {
        staffService.registerStaff(staffDto);

        return "staff_register";
    }

    @RequestMapping("/staff_update")
    public String updateStaff(@RequestBody StaffDto staffDto) {
        staffService.updateStaff(staffDto);

        return "staff_update";
    }


}
