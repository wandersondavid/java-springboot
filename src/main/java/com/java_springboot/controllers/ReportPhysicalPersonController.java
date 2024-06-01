package com.java_springboot.controllers;

import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.dtos.PhysicalPersonDTO;
import com.java_springboot.dtos.ReportPhysicalPersonDTO;
import com.java_springboot.dtos.ResponsePhysicalPersonDTO;
import com.java_springboot.dtos.UpadatePhysicalPersonDTO;
import com.java_springboot.services.PhysicalPersonService;
import com.java_springboot.services.ReportPhysicalPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/report/physical-person")
public class ReportPhysicalPersonController {
    private final ReportPhysicalPersonService reportPhysicalPersonService;

    public ReportPhysicalPersonController(ReportPhysicalPersonService reportPhysicalPersonService) {
        this.reportPhysicalPersonService = reportPhysicalPersonService;
    }

    @PostMapping
    public ResponseEntity<Void> requestReport(@RequestBody ReportPhysicalPersonDTO data) {
        reportPhysicalPersonService.requestReportPerson(data);
        return ResponseEntity.ok().build();
    }
}
