package com.java_springboot.services;

import com.java_springboot.consumers.RequestReportPersonConsumer;
import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.dtos.*;
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
        person.getAddresses().forEach(address -> address.setPhysicalPerson(person));
        repository.save(person);

        return person;
    }

    public List<ResponsePhysicalPersonDTO> getAllPhysicalPerson() {
        return repository.findAll().stream().map(pf ->
                new ResponsePhysicalPersonDTO(
                        pf.getId(),
                        pf.getName(),
                        pf.getCpf(),
                        pf.getPhone(),
                        pf.getAddresses().stream().
                                map(address ->
                                new ResponseAddressDTO(
                                        address.getId(),
                                        address.getNumber(),
                                        address.getComplement(),
                                        address.getNeighborhood(),
                                        address.getCity(),
                                        address.getState(),
                                        address.getZip_code(),
                                        pf.getId()))
                                .toList()))
                .toList();
    }

    public ResponsePhysicalPersonDTO getPhysicalPersonById(String id) {
        var person = repository.findById(id).orElseThrow();
        return new ResponsePhysicalPersonDTO(
                person.getId(),
                person.getName(),
                person.getCpf(),
                person.getPhone(),
                person.getAddresses().stream().
                        map(address ->
                        new ResponseAddressDTO(
                                address.getId(),
                                address.getNumber(),
                                address.getComplement(),
                                address.getNeighborhood(),
                                address.getCity(),
                                address.getState(),
                                address.getZip_code(),
                                person.getId()))
                        .toList());
    }

    public void deletePhysicalPersonById(String id) {
        repository.deleteById(id);
    }

    public PhysicalPerson updatePhysicalPerson(String id, UpadatePhysicalPersonDTO data) {
        var person = repository.findById(id).orElseThrow();
        person.update(data);
        repository.save(person);
        return person;
    }
}
