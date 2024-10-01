package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.ContractorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorTypeRepo extends JpaRepository<ContractorType, Long> {
}
