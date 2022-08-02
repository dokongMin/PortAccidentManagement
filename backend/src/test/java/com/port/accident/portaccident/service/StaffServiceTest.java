package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.staff.Staff;
import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.dto.staff.StaffDto;
import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentResponseActivityDto;
import com.port.accident.portaccident.repository.staff.StaffRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
//@Rollback(value = false)
public class StaffServiceTest {

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StaffService staffService;

    @Test
    public void 비상연락망_등록() {
        //given
        StaffDto staffDto = StaffDto.builder()
                .name("이혜원")
                .corporation("AAA")
                .group("경영")
                .position("사장")
                .email("dfsdfsdf2@naver.com")
                .phoneNumber("01012345678")
                .build();

        //when
        Integer staffId = staffService.saveStaff(staffDto);

        //then
        Staff staff = staffRepository.findById(staffId).get();
        List<Staff> staffList = staffRepository.findAll();

        assertEquals(1, staffList.size());
        assertEquals(staffDto.getName(), staff.getName());
    }

    @Test(expected = IllegalStateException.class)
    public void 비상연락망_중복_예외() {
        //given
        StaffDto staffDto = StaffDto.builder()
                .name("이혜원")
                .corporation("AAA")
                .group("경영")
                .position("사장")
                .email("dfsdfsdf2@naver.com")
                .phoneNumber("01012345678")
                .build();

        StaffDto staffDto2 = StaffDto.builder()
                .name("이혜원")
                .corporation("AAA")
                .group("경영")
                .position("사장")
                .email("dfsdfsdf2@naver.com")
                .phoneNumber("01012345678")
                .build();

        //when
        staffService.saveStaff(staffDto);
        staffService.saveStaff(staffDto2);

        //then
        fail("이미 존재하는 비상연락망입니다.");
    }

    @Test
    public void 비상연락망_수정() {
        //given
        StaffDto staffDto = StaffDto.builder()
                .name("이혜원")
                .corporation("AAA")
                .group("경영")
                .position("사장")
                .email("dfsdfsdf2@naver.com")
                .phoneNumber("01012345678")
                .build();

        Integer staffId = staffService.saveStaff(staffDto);

        StaffDto updateStaffDto = StaffDto.builder()
                .name("이혜원")
                .corporation("BBB")
                .group("경영")
                .position("사장")
                .email("dfsdfsdf2@naver.com")
                .phoneNumber("01012345678")
                .build();

        //when
        Integer updateStaffId = staffService.updateStaff(updateStaffDto);

        //then
        Staff updateStaff = staffRepository.findById(updateStaffId).get();

        Assertions.assertEquals(staffId, updateStaffId);
        Assertions.assertEquals(updateStaffDto.getName(), updateStaff.getName());
        Assertions.assertEquals(updateStaffDto.getCorporation(), updateStaff.getCorporation());
    }

    @Test
    public void 비상연락망_삭제() {
        //given
        StaffDto staffDto = StaffDto.builder()
                .name("이혜원")
                .corporation("AAA")
                .group("경영")
                .position("사장")
                .email("dfsdfsdf2@naver.com")
                .phoneNumber("01012345678")
                .build();

        Integer staffId = staffService.saveStaff(staffDto);

        //when
        staffService.deleteScenario(staffId);

        //then
        Optional<Staff> deleteScenario = staffRepository.findById(staffId);
        assertFalse(deleteScenario.isPresent());
    }

}
