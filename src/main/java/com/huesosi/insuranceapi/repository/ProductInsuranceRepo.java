package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.ProductInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductInsuranceRepo extends JpaRepository<ProductInsurance, UUID> {
}
