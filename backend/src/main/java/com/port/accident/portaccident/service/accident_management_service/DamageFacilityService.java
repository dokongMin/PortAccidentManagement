package com.port.accident.portaccident.service.accident_management_service;


import com.port.accident.portaccident.dto.accident_management.elements.DamageFacilityDto;
import com.port.accident.portaccident.dto.accident_management.elements.DamageFacilityInfoDto;

import com.port.accident.portaccident.repository.accident_management.DamageFacilityInfoRepository;
import com.port.accident.portaccident.repository.accident_management.DamageFacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DamageFacilityService {

    private final DamageFacilityInfoRepository damageFacilityInfoRepository;
    private final DamageFacilityRepository damageFacilityRepository;

    @Transactional
    public Integer saveDamageFacility(DamageFacilityDto damageFacilityDto){
            return damageFacilityRepository.save(damageFacilityDto.toEntity()).getId();
    }

    @Transactional
    public Integer saveDamageFacilityInfo(DamageFacilityInfoDto damageFacilityInfoDto){
        return damageFacilityInfoRepository.save(damageFacilityInfoDto.toEntity()).getId();
    }
}
