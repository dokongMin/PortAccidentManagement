package com.port.accident.portaccident.service;

import com.port.accident.portaccident.domain.staff.Staff;
import com.port.accident.portaccident.dto.staff.StaffDto;
import com.port.accident.portaccident.dto.staff.StaffSearchCondition;
import com.port.accident.portaccident.repository.staff.StaffRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

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
        Integer staffId = staffService.registerStaff(staffDto);

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
        staffService.registerStaff(staffDto);
        staffService.registerStaff(staffDto2);

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

        Integer staffId = staffService.registerStaff(staffDto);

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

        assertEquals(staffId, updateStaffId);
        assertEquals(updateStaffDto.getName(), updateStaff.getName());
        assertEquals(updateStaffDto.getCorporation(), updateStaff.getCorporation());
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

        Integer staffId = staffService.registerStaff(staffDto);

        //when
        staffService.deleteStaff(staffId);

        //then
        Optional<Staff> deleteScenario = staffRepository.findById(staffId);
        assertFalse(deleteScenario.isPresent());
    }

    @Test
    public void 비상연락망_조회_페이징() {
        //given
        IntStream.rangeClosed(1, 5).forEach(i -> {
            StaffDto staffDto = StaffDto.builder()
                    .name("이혜원" + i)
                    .build();

            staffService.registerStaff(staffDto);
        });

        StaffSearchCondition searchCondition = new StaffSearchCondition();
        PageRequest pageRequest = PageRequest.of(0, 3); // Sort.by(Sort.Direction.DESC, "name")

        //when
        Page<Staff> staff = staffService.searchPageStaff(searchCondition, pageRequest);

        //then
        List<Staff> content = staff.getContent();
        assertEquals("조회된 데이터 수", 3, content.size());
        assertEquals("전체 데이터 수", 5, staff.getTotalElements());
        assertEquals("페이지 번호", 0, staff.getNumber());
        assertEquals("전체 페이지 번호", 2, staff.getTotalPages());
        assertTrue("첫번째 항목인가?", staff.isFirst());
        assertTrue("다음 페이지가 있는가?", staff.hasNext());
    }

    @Test
    public void 비상연락망_검색_페이징() {
        //given
        IntStream.rangeClosed(1, 5).forEach(i -> {
            StaffDto staffDto = StaffDto.builder()
                    .name("이혜원" + i)
                    .corporation("AAA")
                    .build();

            staffService.registerStaff(staffDto);

            StaffDto staffDto2 = StaffDto.builder()
                    .name("박태영" + i)
                    .corporation("AAA")
                    .build();

            staffService.registerStaff(staffDto2);
        });

        StaffSearchCondition searchCondition = new StaffSearchCondition();
        searchCondition.setName("이혜원");
        searchCondition.setCorporation("AAA");

        PageRequest pageRequest = PageRequest.of(0, 3);

        //when
        Page<Staff> staff = staffService.searchPageStaff(searchCondition, pageRequest);

        //then
        List<Staff> content = staff.getContent();
        assertEquals("조회된 데이터 수", 3, content.size());
        assertEquals("전체 데이터 수", 5, staff.getTotalElements());
        assertEquals("페이지 번호", 0, staff.getNumber());
        assertEquals("전체 페이지 번호", 2, staff.getTotalPages());
        assertTrue("첫번째 항목인가?", staff.isFirst());
        assertTrue("다음 페이지가 있는가?", staff.hasNext());
    }
}
