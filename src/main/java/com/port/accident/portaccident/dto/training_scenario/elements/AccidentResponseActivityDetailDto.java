package com.port.accident.portaccident.dto.training_scenario.elements;


import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class AccidentResponseActivityDetailDto {
    private Integer id;
    private String comment;
    private String manager;
    private LocalDateTime completePlaningTime;

    @QueryProjection
    public AccidentResponseActivityDetailDto(Integer id, String comment, String manager, LocalDateTime completePlaningTime) {
        this.id = id;
        this.comment = comment;
        this.manager = manager;
        this.completePlaningTime = completePlaningTime;
    }
}
