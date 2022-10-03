package com.port.accident.portaccident.repository.staff;

import com.port.accident.portaccident.domain.staff.Staff;
import com.port.accident.portaccident.dto.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffRepositoryCustom {
    Page<Staff> searchPage(SearchCondition condition, Pageable pageable);
}
