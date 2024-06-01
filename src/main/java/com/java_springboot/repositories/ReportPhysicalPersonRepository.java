package com.java_springboot.repositories;

import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.domain.report.person.ReportPhysicalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportPhysicalPersonRepository extends JpaRepository<ReportPhysicalPerson, String> {
}
