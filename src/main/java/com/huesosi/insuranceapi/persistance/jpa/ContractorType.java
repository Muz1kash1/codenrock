package com.huesosi.insuranceapi.persistance.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class ContractorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contractor_type_id")
    private int id;

    @Column(unique = true)
    private String name;

    @Column(unique = true, nullable = false)
    private String abbreviation;

    public ContractorType(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }
}
