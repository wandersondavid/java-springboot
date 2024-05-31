package com.java_springboot.domain.person;

import com.java_springboot.domain.address.Address;
import com.java_springboot.dtos.PhysicalPersonDTO;
import jakarta.persistence.*;
import lombok.*;

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
    @OneToMany(mappedBy = "physical_person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    public PhysicalPerson(PhysicalPersonDTO data) {
        this.name = data.name();
        this.cpf = data.cpf();
        this.phone = data.phone();
    }

}
