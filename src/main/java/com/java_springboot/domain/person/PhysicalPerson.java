package com.java_springboot.domain.person;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="physical_person")
@Table(name="physical_person")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class PhysicalPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @Column(unique = true)
    private String cpf;
    private String phone;

}
