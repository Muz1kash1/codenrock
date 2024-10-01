package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepo extends JpaRepository<ProductType, Integer> {
}
