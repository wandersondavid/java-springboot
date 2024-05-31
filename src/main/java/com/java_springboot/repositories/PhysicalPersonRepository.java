package com.java_springboot.repositories;
import com.java_springboot.domain.person.PhysicalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PhysicalPersonRepository  extends JpaRepository<PhysicalPerson, String> {
    Optional<PhysicalPerson> findByCpf(String cpf);
    Optional<PhysicalPerson> findById(String id);
}
