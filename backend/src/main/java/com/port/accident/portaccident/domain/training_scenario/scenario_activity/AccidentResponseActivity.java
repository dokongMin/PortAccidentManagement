package com.port.accident.portaccident.domain.training_scenario.scenario_activity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "accident_response_activity")
@Entity
@Getter
public class AccidentResponseActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_response_activity_id")
    private Integer id;

    @Column(name = "accident_response_activity_name")
    private String name;

    @Column(name = "accident_response_activity_manager")
    private String manager;

    @Column(name = "accident_response_complete_planing_time")
    private LocalDateTime completePlaningTime;
}
