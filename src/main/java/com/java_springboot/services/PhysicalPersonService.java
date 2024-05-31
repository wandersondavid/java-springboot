package com.java_springboot.services;

import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.dtos.PhysicalPersonDTO;
import com.java_springboot.repositories.PhysicalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicalPersonService {
    @Autowired
    private PhysicalPersonRepository repository;

    private void validateCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF must have 11 digits");
        }

        if(repository.findByCpf(cpf).isPresent()) {
            throw new IllegalArgumentException("CPF already exists");
        }
    }

    public PhysicalPerson createPhysicalPerson(PhysicalPersonDTO data) {
        validateCpf(data.cpf());
        var person = new PhysicalPerson(data);
        repository.save(person);

        return person;
    }

    public List<PhysicalPerson> getAllPhysicalPerson() {
        return repository.findAll();
    }
}
