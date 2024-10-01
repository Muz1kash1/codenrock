package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.InsuranceRisk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRiskRepo extends JpaRepository<InsuranceRisk, Long> {
}
