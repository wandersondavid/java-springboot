package com.java_springboot.controllers;

import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.dtos.PhysicalPersonDTO;
import com.java_springboot.dtos.ResponsePhysicalPersonDTO;
import com.java_springboot.dtos.UpadatePhysicalPersonDTO;
import com.java_springboot.services.PhysicalPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/physical-person")
public class PhysicalPersonController {
    private final PhysicalPersonService physicalPersonService;

    public PhysicalPersonController(PhysicalPersonService physicalPersonService) {
        this.physicalPersonService = physicalPersonService;
    }

    @PostMapping
    public ResponseEntity<PhysicalPerson> createPhysicalPerson(@RequestBody PhysicalPersonDTO data) {
        physicalPersonService.createPhysicalPerson(data);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/report")
    public ResponseEntity<Void> requestReport() {
        physicalPersonService.requestReportPerson();
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ResponsePhysicalPersonDTO>> getAllPhysicalPerson() {
        return ResponseEntity.ok(physicalPersonService.getAllPhysicalPerson());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePhysicalPersonDTO> getPhysicalPersonById(@PathVariable String id) {
        return ResponseEntity.ok(physicalPersonService.getPhysicalPersonById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhysicalPersonById(@PathVariable String id) {
        physicalPersonService.deletePhysicalPersonById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PhysicalPerson> updatePhysicalPerson(@PathVariable String id, @RequestBody UpadatePhysicalPersonDTO data) {
        return ResponseEntity.ok(physicalPersonService.updatePhysicalPerson(id, data));
    }


}
