package com.java_springboot.domain.report.person;

import com.java_springboot.dtos.ReportPhysicalPersonDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity(name="report_physical_person")
@Table(name="report_physical_person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class ReportPhysicalPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String status;
    private String url;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant created_at = Instant.now();

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updated_at = Instant.now();

    public ReportPhysicalPerson(ReportPhysicalPersonDTO data) {
        this.status = data.status();
        this.url = data.url();
    }
}
