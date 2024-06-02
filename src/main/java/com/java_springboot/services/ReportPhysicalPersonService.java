package com.java_springboot.services;
import com.java_springboot.consumers.RequestReportPersonConsumer;
import com.java_springboot.domain.report.person.ReportPhysicalPerson;
import com.java_springboot.dtos.ReportPhysicalPersonDTO;
import com.java_springboot.dtos.ResponseReportPhysicalPersonDTO;
import com.java_springboot.repositories.ReportPhysicalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportPhysicalPersonService {

    @Autowired
    private RequestReportPersonConsumer requestReportPerson;

    @Autowired
    private ReportPhysicalPersonRepository repository;


    public void requestReportPerson(ReportPhysicalPersonDTO data) {
        var report = new ReportPhysicalPerson(data);
        repository.save(report);
        requestReportPerson.requestReport();
    }

    public List<ResponseReportPhysicalPersonDTO> getAllPhysicalPerson() {
        return repository.findAll().stream().map(
                report -> new ResponseReportPhysicalPersonDTO(
                        report.getId(),
                        report.getStatus(),
                        report.getUrl(),
                        report.getUpdated_at().toString(),
                        report.getCreated_at().toString()
                )
        ).toList();
    }


}
