package com.port.accident.portaccident.repository.training_scenario_result.evaluation;

import com.port.accident.portaccident.domain.training_scenario_result.evaluation.EvaluationDetails;
import com.port.accident.portaccident.repository.code.CodeRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationDetailsRepository extends JpaRepository<EvaluationDetails, Integer> {
}
