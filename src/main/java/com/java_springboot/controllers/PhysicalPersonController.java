package com.java_springboot.controllers;

import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.dtos.PhysicalPersonDTO;
import com.java_springboot.dtos.ResponsePhysicalPersonDTO;
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

        return ResponseEntity.ok(physicalPersonService.createPhysicalPerson(data));
    }

    @GetMapping
    public ResponseEntity<List<ResponsePhysicalPersonDTO>> getAllPhysicalPerson() {
        return ResponseEntity.ok(physicalPersonService.getAllPhysicalPerson());
    }
}
