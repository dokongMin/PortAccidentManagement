package com.port.accident.portaccident.domain.training_scenario.elements;

import com.port.accident.portaccident.domain.training_scenario.Scenario;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "accident_response_activity")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;

    @Builder
    public AccidentResponseActivity(Integer id, String name, String manager, LocalDateTime completePlaningTime, Scenario scenario) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.completePlaningTime = completePlaningTime;
        this.scenario = scenario;
    }
}
