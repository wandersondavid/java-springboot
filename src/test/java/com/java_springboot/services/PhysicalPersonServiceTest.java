package com.java_springboot.services;

import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.dtos.AddressDTO;
import com.java_springboot.dtos.PhysicalPersonDTO;
import com.java_springboot.dtos.ResponsePhysicalPersonDTO;
import com.java_springboot.dtos.UpadatePhysicalPersonDTO;
import com.java_springboot.repositories.PhysicalPersonRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import static  org.assertj.core.api.Assertions.assertThat;

import java.util.List;


@SpringBootTest
@ActiveProfiles("test")
class PhysicalPersonServiceTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    PhysicalPersonRepository physicalPersonRepository;

    @Autowired
    @InjectMocks
    private  PhysicalPersonService physicalPersonService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("Should create Physical Person")
    void createPhysicalPerson() {
        List<AddressDTO> addresses = List.of(new AddressDTO("123", "test", "Bairro 1", "Cidade 1", "SP", "12345678" , "12345678901"));
        PhysicalPersonDTO  data = new PhysicalPersonDTO("12345678901", "12345678901", "64993446559", addresses);
        PhysicalPerson physicalPerson = this.physicalPersonService.createPhysicalPerson(data);
        assertThat(physicalPerson).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("Should return error when create Physical Person")
    void createPhysicalPersonError() {
        List<AddressDTO> addresses = List.of(new AddressDTO("123", "test", "Bairro 1", "Cidade 1", "SP", "12345678" , "12345678901"));
        PhysicalPersonDTO  data = new PhysicalPersonDTO("12345678901", "12345678901", "64993446559", addresses);
        PhysicalPerson physicalPerson = this.physicalPersonService.createPhysicalPerson(data);
        assertThat(physicalPerson).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("Should find By Cpf - Success")
    void findByCpfSuccess() {
        String cpf = "12345678901";
        List<AddressDTO> addresses = List.of(new AddressDTO("123", "test", "Bairro 1", "Cidade 1", "SP", "12345678" , "12345678901"));
        PhysicalPersonDTO  data = new PhysicalPersonDTO("12345678901", cpf, "64993446559", addresses);
        this.physicalPersonService.createPhysicalPerson(data);
        this.physicalPersonService.findByCpf(cpf);
    }


    @Test
    @Transactional
    @Rollback
    @DisplayName("Should find By id - Success")
    void findByIdSuccess() {
        List<AddressDTO> addresses = List.of(new AddressDTO("123", "test", "Bairro 1", "Cidade 1", "SP", "12345678" , "12345678901"));
        PhysicalPersonDTO  data = new PhysicalPersonDTO("12345678901", "12345678901", "64993446559", addresses);
        PhysicalPerson physicalPerson = this.physicalPersonService.createPhysicalPerson(data);
        ResponsePhysicalPersonDTO physicalPersonFound = this.physicalPersonService.getPhysicalPersonById(physicalPerson.getId());
        assertThat(physicalPersonFound).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("Should find By id - Error")
    void findByIdError() {
        List<AddressDTO> addresses = List.of(new AddressDTO("123", "test", "Bairro 1", "Cidade 1", "SP", "12345678" , "12345678901"));
        PhysicalPersonDTO  data = new PhysicalPersonDTO("12345678901", "12345678901", "64993446559", addresses);
        this.physicalPersonService.createPhysicalPerson(data);
        ResponsePhysicalPersonDTO physicalPersonFound = this.physicalPersonService.getPhysicalPersonById("2");
        assertThat(physicalPersonFound).isNull();
    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("Should find all - Success")
    void findAllSuccess() {
        List<AddressDTO> addresses = List.of(new AddressDTO("123", "test", "Bairro 1", "Cidade 1", "SP", "12345678" , "12345678901"));
        PhysicalPersonDTO  data = new PhysicalPersonDTO("12345678901", "12345678901", "64993446559", addresses);
        this.physicalPersonService.createPhysicalPerson(data);
        List<ResponsePhysicalPersonDTO> physicalPersonFound = this.physicalPersonService.getAllPhysicalPerson();
        assertThat(physicalPersonFound).isNotNull();
    }
    @Test
    @Transactional
    @Rollback
    @DisplayName("Delete Physical Person - Success")
    void deletePhysicalPersonSuccess() {
        List<AddressDTO> addresses = List.of(new AddressDTO("123", "test", "Bairro 1", "Cidade 1", "SP", "12345678" , "12345678901"));
        PhysicalPersonDTO  data = new PhysicalPersonDTO("12345678901", "12345678901", "64993446559", addresses);
        PhysicalPerson physicalPerson = this.physicalPersonService.createPhysicalPerson(data);
        this.physicalPersonService.deletePhysicalPersonById(physicalPerson.getId());
    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("Should delete Physical Person - Error")
    void deletePhysicalPersonError() {
        List<AddressDTO> addresses = List.of(new AddressDTO("123", "test", "Bairro 1", "Cidade 1", "SP", "12345678" , "12345678901"));
        PhysicalPersonDTO  data = new PhysicalPersonDTO("12345678901", "12345678901", "64993446559", addresses);
        this.physicalPersonService.createPhysicalPerson(data);
        this.physicalPersonService.deletePhysicalPersonById("2");
    }
    
}