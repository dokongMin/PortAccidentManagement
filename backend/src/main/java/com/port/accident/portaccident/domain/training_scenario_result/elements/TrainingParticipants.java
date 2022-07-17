package com.port.accident.portaccident.domain.training_scenario_result.elements;


import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "training_participants")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TrainingParticipants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_participants_id")
    private Integer id;

    @Column(name = "participants_id")
    private Integer participantsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_result_id")
    private TrainingResult trainingResult;
}
