package com.java_springboot.repositories;

import com.java_springboot.domain.person.PhysicalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<PhysicalPerson, String> {
}
