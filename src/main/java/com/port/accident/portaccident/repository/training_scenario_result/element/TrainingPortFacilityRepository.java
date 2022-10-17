package com.port.accident.portaccident.repository.training_scenario_result.element;

import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TrainingPortFacilityRepository extends JpaRepository<TrainingPortFacility, Integer> {
    @Transactional
    @Modifying
    @Query("delete from TrainingPortFacility f where f.trainingResult.id =:trainingResultId")
    int deleteFacilityByTrainingResultId(Integer trainingResultId);

    @Query("select f from TrainingPortFacility f where f.trainingResult.id = :trainingResultId")
    List<TrainingPortFacility> findAllByTrainingResultId(int trainingResultId);
}
