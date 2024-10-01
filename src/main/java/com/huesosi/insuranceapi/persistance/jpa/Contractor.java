package com.huesosi.insuranceapi.persistance.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
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

    @Column(nullable = true)
    private String middleName;

    @Column(nullable = true)
    private LocalDate birthDate;

    @Column(unique = true)
    private String legalEntityName;

    @Column(unique = true, length = 12)
    private String inn;

    @ManyToOne
    @JoinColumn(name = "contractor_type_id")
    private ContractorType contractorType;
}