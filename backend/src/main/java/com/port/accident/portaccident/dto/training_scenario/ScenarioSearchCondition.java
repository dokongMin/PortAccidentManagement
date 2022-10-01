package com.port.accident.portaccident.dto.training_scenario;

import com.port.accident.portaccident.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ScenarioSearchCondition {
    private String name;
    private IncidentLevel incidentLevel;
    private IncidentType incidentType;
    private IncidentDetailType incidentDetailType;
}
