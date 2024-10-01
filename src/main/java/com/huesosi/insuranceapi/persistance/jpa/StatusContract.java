package com.huesosi.insuranceapi.persistance.jpa;

import jakarta.persistence.*;

@Entity
public class StatusContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int id;

    @Column(unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String abbreviation;

}
