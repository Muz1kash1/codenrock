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
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(unique = true)
    private String name;
    @Column(unique = true, nullable = false)
    private String abbreviation;

    public Category(String name) {
        this.name = name;
    }
}
