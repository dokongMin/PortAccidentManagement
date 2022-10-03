package com.port.accident.portaccident.repository.training_scenario_result.element;

import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingParticipants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TrainingParticipantsRepository extends JpaRepository<TrainingParticipants, Integer>{

    @Transactional
    @Modifying
    @Query("delete from TrainingParticipants p where p.trainingResult.id =:trainingResultId")
    void deleteParticipantsByTrainingResultId(Integer trainingResultId);
}
