package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.ContractorContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContractorContractRepo extends JpaRepository<ContractorContract, UUID> {
}
