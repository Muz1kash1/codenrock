package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
