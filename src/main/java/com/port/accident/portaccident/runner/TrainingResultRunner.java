//package com.port.accident.portaccident.runner;
//
//import com.port.accident.portaccident.domain.training_scenario.Scenario;
//import com.port.accident.portaccident.domain.training_scenario_result.TrainingResult;
//import com.port.accident.portaccident.domain.training_scenario_result.elements.TrainingPortFacility;
//import com.port.accident.portaccident.dto.training_scenario.ScenarioDto;
//import com.port.accident.portaccident.dto.training_scenario.elements.AccidentPortFacilityDto;
//import com.port.accident.portaccident.dto.training_scenario.elements.AccidentResponseActivityDto;
//import com.port.accident.portaccident.dto.training_scenario_result.TrainingResultDto;
//import com.port.accident.portaccident.dto.training_scenario_result.elements.TrainingParticipantsDto;
//import com.port.accident.portaccident.dto.training_scenario_result.elements.TrainingPortFacilityDto;
//import com.port.accident.portaccident.enums.*;
//import com.port.accident.portaccident.service.ScenarioService;
//import com.port.accident.portaccident.service.TrainingResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Profile("local")
//@Component
//public class TrainingResultRunner implements org.springframework.boot.ApplicationRunner {
//
//    @Autowired
//    TrainingResultService resultService;
//
//    @Autowired
//    ScenarioService scenarioService;
//
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Optional<Scenario> scenario1 = scenarioService.findById(1);
//        Optional<Scenario> scenario2 = scenarioService.findById(2);
//        Optional<Scenario> scenario3 = scenarioService.findById(3);
//        Integer trainingResultId = 0;
//        /* create TrainingResult */
//        //given
//        for (int i = 1; i <= 30; i++) {
//            TrainingResultDto dto = null;
//            if (i <= 10) {
//                dto = TrainingResultDto.builder()
//                        .name("대응훈련결과명" + i)
//                        .startDate(LocalDateTime.of(2022, 3, 10, 12, 00))
//                        .endDate(LocalDateTime.of(2022, 3, 12, 12, 00))
//                        .place(TrainingPlace.PLACE1)
//                        .trainingType(TrainingType.ACTUAL)
//                        .incidentLevel(IncidentLevel.LEVEL_1)
//                        .incidentImpact(IncidentImpact.DAMAGE)
//                        .incidentType(IncidentType.INCIDENT)
//                        .incidentDetailType("추락")
//                        .department("안전관리부서A")
//                        .trainingArea("훈련대상 항만구역 A")
//                        .scenario(scenario1.get())
//                        .build();
//            } else if (i <= 20) {
//                dto = TrainingResultDto.builder()
//                        .name("대응훈련결과명" + i)
//                        .startDate(LocalDateTime.of(2022, 3, 10, 12, 00))
//                        .endDate(LocalDateTime.of(2022, 3, 12, 12, 00))
//                        .place(TrainingPlace.PLACE2)
//                        .trainingType(TrainingType.ACTUAL)
//                        .incidentLevel(IncidentLevel.LEVEL_2)
//                        .incidentImpact(IncidentImpact.SLIGHT)
//                        .incidentType(IncidentType.DISASTER)
//                        .incidentDetailType("끼임")
//                        .department("안전관리부서B")
//                        .trainingArea("훈련대상 항만구역 B")
//                        .scenario(scenario2.get())
//                        .build();
//            } else if (i <= 30) {
//                dto = TrainingResultDto.builder()
//                        .name("대응훈련결과명" + i)
//                        .startDate(LocalDateTime.of(2022, 3, 10, 12, 00))
//                        .endDate(LocalDateTime.of(2022, 3, 12, 12, 00))
//                        .place(TrainingPlace.PLACE3)
//                        .trainingType(TrainingType.VIRTUAL)
//                        .incidentLevel(IncidentLevel.LEVEL_3)
//                        .incidentImpact(IncidentImpact.SERIOUS)
//                        .incidentType(IncidentType.INCIDENT)
//                        .incidentDetailType("넘어짐")
//                        .department("안전관리부서C")
//                        .trainingArea("훈련대상 항만구역 C")
//                        .scenario(scenario3.get())
//                        .build();
//            }
//
//             trainingResultId = resultService.createTrainingResult(dto.toEntity());
//        }
//        TrainingResult trainingResult = resultService.findByTrainingResultId(trainingResultId);
//
//        /* create TrainingPortFacilityRepository */
//        //given
//        TrainingPortFacilityDto facilityDto = TrainingPortFacilityDto.builder()
//                .name(PortFacility.CONTAINER)
//                .trainingResult(trainingResult)
//                .build();
//
//        //when
//        resultService.createPortFacility(facilityDto.toEntity());
//
//        /* create TrainingParticipants */
//        //given
//        TrainingParticipantsDto participantsDto = TrainingParticipantsDto.builder()
//                .participantsId(1)
//                .trainingResult(trainingResult)
//                .build();
//
//        //when
//        resultService.createTrainingParticipants(participantsDto.toEntity());
//    }
//}
