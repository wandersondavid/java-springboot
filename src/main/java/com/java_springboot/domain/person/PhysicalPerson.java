package com.java_springboot.domain.person;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java_springboot.domain.address.Address;
import com.java_springboot.dtos.PhysicalPersonDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="physical_person")
@Table(name="physical_person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class PhysicalPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @Column(unique = true)
    private String cpf;
    private String phone;

    @OneToMany(mappedBy = "physicalPerson", cascade = CascadeType.ALL)
    private List<Address> addresses ;

    public PhysicalPerson(PhysicalPersonDTO data) {
        this.name = data.name();
        this.cpf = data.cpf();
        this.phone = data.phone();
        this.addresses = data.addresses().stream().map(Address::new).toList();
    }

}
