package com.port.accident.portaccident.dto.training_scenario_result;

import com.port.accident.portaccident.enums.IncidentLevel;
import com.port.accident.portaccident.enums.IncidentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainingResultCondition {
    private IncidentType incidentType;
    private String name;
    private IncidentLevel incidentLevel;
    private String incidentDetailType;
    private String department;

    public TrainingResultCondition(String name, String incidentDetailType, String department) {
        this.name = name;
        this.incidentDetailType = incidentDetailType;
        this.department = department;
    }
}
