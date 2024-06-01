package com.java_springboot.services;
import com.java_springboot.consumers.RequestReportPersonConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportPhysicalPersonService {

    @Autowired
    private RequestReportPersonConsumer requestReportPerson;


    public void requestReportPerson() {
        requestReportPerson.requestReport();
    }

}
