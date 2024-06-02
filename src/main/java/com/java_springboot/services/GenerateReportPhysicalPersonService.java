package com.java_springboot.services;

import com.java_springboot.consumers.RequestReportPersonConsumer;
import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.domain.report.person.ReportPhysicalPerson;
import com.java_springboot.dtos.ReportPhysicalPersonDTO;
import com.java_springboot.repositories.PhysicalPersonRepository;
import com.java_springboot.repositories.ReportPhysicalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class GenerateReportPhysicalPersonService {
    @Autowired
    private PhysicalPersonRepository physicalPersonRepository;

    @Autowired
    private ReportPhysicalPersonRepository repository;

    @Transactional
    public void generateReportPerson() {
       try {
            List<PhysicalPerson> persons = physicalPersonRepository.findAll();
            String csvContent = generateCsv(persons);

           var file = new java.io.File("src/report/"+ UUID.randomUUID().toString() + ".csv");
           saveCsvToFile(csvContent, file.getAbsolutePath());

           ReportPhysicalPersonDTO reportPhysicalPersonDTO = new ReportPhysicalPersonDTO("done", file.getAbsolutePath());

           var reportPhysicalPersonService = new ReportPhysicalPerson(reportPhysicalPersonDTO);
           repository.save(reportPhysicalPersonService);

        } catch (Exception e) {
            e.printStackTrace();
       } finally {
           System.out.println("Report generated");
       }
    }

    private  String generateCsv(List<PhysicalPerson> persons) {
        StringBuilder csv = new StringBuilder();
        csv.append("Name,CPF,Phone,Number,Complement,Neighborhood,City,State,Zip code\n");
        persons.forEach(person -> {
            csv.append(person.getName()).append(",");
            csv.append(person.getCpf()).append(",");
            csv.append(person.getPhone()).append(",");
            person.getAddresses().forEach(address -> {
                csv.append(address.getNumber()).append(",");
                csv.append(address.getComplement()).append(",");
                csv.append(address.getNeighborhood()).append(",");
                csv.append(address.getCity()).append(",");
                csv.append(address.getState()).append(",");
                csv.append(address.getZip_code()).append("\n");
            });
        });
        return csv.toString();
    }

    private void saveCsvToFile(String csvContent, String filePath) {
        try {
            java.nio.file.Files.write(java.nio.file.Paths.get(filePath), csvContent.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
