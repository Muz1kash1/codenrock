package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.StatusContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusContractRepo extends JpaRepository<StatusContract, Integer> {
}
