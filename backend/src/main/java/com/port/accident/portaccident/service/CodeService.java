package com.port.accident.portaccident.service;

import com.port.accident.portaccident.repository.code.DetailedCodeRepository;
import com.port.accident.portaccident.repository.code.RepresentativeCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CodeService {

    @Autowired
    DetailedCodeRepository detailedRepository;

    @Autowired
    RepresentativeCodeRepository representRepository;


}
