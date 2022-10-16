package com.port.accident.portaccident.domain.training_scenario.elements;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.port.accident.portaccident.domain.training_scenario.Scenario;
import com.port.accident.portaccident.dto.training_scenario.elements.AccidentResponseActivityDto;
import com.port.accident.portaccident.enums.IncidentLevel;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "accident_response_activity")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccidentResponseActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_response_activity_id") // 안전 사고 대응 활동 id
    private Integer id;

    @Column(name = "accident_response_activity_comment") // 사고 대응 활동 내용
    private String comment;

    @Column(name = "accident_response_activity_manager") // 사고 대응 활동 담당
    private String manager;

    @Column(name = "accident_response_complete_planing_time") // 사고 대응 활동 완료 계획 시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime completePlaningTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_id") // 훈련 시나리오 id
    private Scenario scenario;

    @Builder
    public AccidentResponseActivity(Integer id, String comment, String manager, LocalDateTime completePlaningTime, Scenario scenario) {
        this.id = id;
        this.comment = comment;
        this.manager = manager;
        this.completePlaningTime = completePlaningTime;
        this.scenario = scenario;
    }

    @Transactional(readOnly = true)
    public void update(AccidentResponseActivityDto accidentResponseActivityDto) {
        this.comment = accidentResponseActivityDto.getComment();
        this.manager = accidentResponseActivityDto.getManager();
        this.completePlaningTime = accidentResponseActivityDto.getCompletePlaningTime();
    }
}
