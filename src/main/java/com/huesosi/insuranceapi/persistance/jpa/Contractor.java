package com.huesosi.insuranceapi.persistance.jpa;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "contractor_id")
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String middleName;
    private LocalDate birthDate;

    @Column(unique = true)
    private String legalEntityName;

    @Column(unique = true, length = 12)
    private short inn;

    @ManyToOne
    @JoinColumn(name = "contractor_type_id")
    private ContractorType contractorType;
}