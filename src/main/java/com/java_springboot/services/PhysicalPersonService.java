package com.java_springboot.services;

import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.dtos.AddressDTO;
import com.java_springboot.dtos.PhysicalPersonDTO;
import com.java_springboot.dtos.ResponseAddressDTO;
import com.java_springboot.dtos.ResponsePhysicalPersonDTO;
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
}
