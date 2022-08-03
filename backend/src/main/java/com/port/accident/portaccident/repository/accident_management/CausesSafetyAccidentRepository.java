package com.port.accident.portaccident.repository.accident_management;

import com.port.accident.portaccident.domain.accident_management.elements.CausesSafetyAccident;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CausesSafetyAccidentRepository extends JpaRepository<CausesSafetyAccident, Integer> {


    Optional<CausesSafetyAccident> findByName(String name);
}
