package com.java_springboot.repositories;

import com.java_springboot.domain.report.person.ReportPhysicalPerson;
import com.java_springboot.dtos.ReportPhysicalPersonDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ReportPhysicalPersonRepositoryTest {
    @Autowired
    EntityManager entityManager;
    @Autowired
    ReportPhysicalPersonRepository reportPhysicalPersonRepository;
    @Test
    @DisplayName("Should find all by order by created at desc")
    @Transactional
    void findAllByOrderByCreatedAtDesc() {
        ReportPhysicalPersonDTO data = new ReportPhysicalPersonDTO("done", "test.com");

        this.createReportPhysicalPerson(data);

        ReportPhysicalPersonDTO data2 = new ReportPhysicalPersonDTO("done", "test2.com");

        this.createReportPhysicalPerson(data2);

        var reportPhysicalPerson = this.reportPhysicalPersonRepository.findAllByOrderByCreatedAtDesc();

        assertEquals(2, reportPhysicalPerson.size());
    }


    private ReportPhysicalPerson createReportPhysicalPerson(ReportPhysicalPersonDTO data) {
        ReportPhysicalPerson reportPhysicalPerson = new ReportPhysicalPerson(data);
        this.entityManager.persist(reportPhysicalPerson);
        return reportPhysicalPerson;
    }
}