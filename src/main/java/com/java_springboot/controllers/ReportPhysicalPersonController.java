package com.java_springboot.controllers;

import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.dtos.*;
import com.java_springboot.services.PhysicalPersonService;
import com.java_springboot.services.ReportPhysicalPersonService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.io.OutputStream;
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

    @GetMapping
    public ResponseEntity<List<ResponseReportPhysicalPersonDTO>> getAllPhysicalPerson() {
        return ResponseEntity.ok(reportPhysicalPersonService.getAllPhysicalPerson());
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<ResponseReportPhysicalPersonDTO> getPhysicalPersonById(@PathVariable String id, HttpServletResponse response) {

        try {
            InputStream report = reportPhysicalPersonService.downloadReportPhysicalPerson(id);
            response.setContentType("application/csv");
            response.setHeader("Content-Disposition", "attachment; filename=report.csv");
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = report.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
            out.close();
            report.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }
}
