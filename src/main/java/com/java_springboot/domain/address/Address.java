package com.java_springboot.domain.address;

import com.java_springboot.domain.auditable.Auditable;
import com.java_springboot.domain.person.PhysicalPerson;
import com.java_springboot.dtos.AddressDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="address")
@Table(name="address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")

public class Address extends Auditable  {
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
        private PhysicalPerson physicalPerson;

        public Address(AddressDTO data) {
            this.number = data.number();
            this.complement = data.complement();
            this.neighborhood = data.neighborhood();
            this.city = data.city();
            this.state = data.state();
            this.zip_code = data.zip_code();
        }
}
