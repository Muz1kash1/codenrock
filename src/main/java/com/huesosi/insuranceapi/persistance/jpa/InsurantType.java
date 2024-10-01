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
public class InsurantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurant_type_id")
    private int id;

    private String name;

    @Column(nullable = false, unique = true)
    private String abbreviation;

    public InsurantType(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }
}
