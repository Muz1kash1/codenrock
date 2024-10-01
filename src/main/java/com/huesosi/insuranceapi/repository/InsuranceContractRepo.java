package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.InsuranceContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InsuranceContractRepo extends JpaRepository<InsuranceContract, UUID> {
}
