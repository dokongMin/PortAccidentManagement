package com.port.accident.portaccident.repository.staff;

import com.port.accident.portaccident.domain.staff.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

    @Query("select s from Staff s where s.phoneNumber = :phoneNumber")
    Optional<Staff> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

/*
    @Query("select s from Staff s where s.email = :email")
    Optional<Staff> findByEmail(@Param("email") String email);
*/
}
