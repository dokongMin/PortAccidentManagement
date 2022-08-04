package com.port.accident.portaccident.repository.accident_management;

import com.port.accident.portaccident.domain.accident_management.elements.DamageFacility;
import com.port.accident.portaccident.domain.accident_management.elements.DamageFacilityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageFacilityInfoRepository extends JpaRepository<DamageFacilityInfo, Integer> {

    
}
