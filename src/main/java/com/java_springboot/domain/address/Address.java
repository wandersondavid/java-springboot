package com.java_springboot.domain.address;

import com.java_springboot.domain.person.PhysicalPerson;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="address")
@Table(name="address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;
        private String number;
        private String complement;
        private String neighborhood;
        private String city;
        private String state;
        private String zip_code;

        @ManyToOne
        @JoinColumn(name = "physical_person_id")
        private PhysicalPerson physical_person;

}
