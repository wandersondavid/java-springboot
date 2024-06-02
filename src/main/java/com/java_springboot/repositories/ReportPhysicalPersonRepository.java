package com.java_springboot.repositories;

import com.java_springboot.domain.report.person.ReportPhysicalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportPhysicalPersonRepository extends JpaRepository<ReportPhysicalPerson, String> {
    List<ReportPhysicalPerson> findAllByOrderByCreatedAtDesc();
}
