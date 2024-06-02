package com.java_springboot.repositories;

import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.dtos.AddressDTO;
import com.java_springboot.dtos.PhysicalPersonDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static  org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
class JavaSpringbootApplicationTests {

    @Autowired
    EntityManager entityManager;

    @Autowired
    PhysicalPersonRepository physicalPersonRepository;

    @Test
    @Transactional
    @Rollback
    @DisplayName("Should find By Cpf - Success")
    void findByCpfSuccess() {
        String cpf = "12345678901";
        List<AddressDTO> addresses = List.of(new AddressDTO("123", "test", "Bairro 1", "Cidade 1", "SP", "12345678" , "12345678901"));
        PhysicalPersonDTO  data = new PhysicalPersonDTO("12345678901", cpf, "64993446559", addresses);
        this.createPhysicalPerson(data);
        Optional<PhysicalPerson> physicalPerson = this.physicalPersonRepository.findByCpf(cpf);
        assertThat(physicalPerson.isPresent()).isTrue();
    }

    private PhysicalPerson createPhysicalPerson(PhysicalPersonDTO data) {
        PhysicalPerson physicalPerson = new PhysicalPerson(data);
        this.entityManager.persist(physicalPerson);
        return physicalPerson;
    }

}
