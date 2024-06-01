package com.java_springboot.domain.report.person;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Entity(name="report_physical_person")
@Table(name="report_physical_person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class PhysicalPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String status;
    private Timestamp created_at;
    private Timestamp updated_at;

}
