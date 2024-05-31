package com.java_springboot.services;

import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.repositories.PhysicalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhysicalPersonService {
    @Autowired
    private PhysicalPersonRepository repository;

    public PhysicalPersonService(PhysicalPersonRepository repository) {
        this.repository = repository;
    }

    public void validateCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF must have 11 digits");
        }

        if(repository.findByCpf(cpf).isPresent()) {
            throw new IllegalArgumentException("CPF already exists");
        }
    }

    public void save(PhysicalPerson physicalPerson) {
        validateCpf(physicalPerson.getCpf());
        repository.save(physicalPerson);
    }


}
