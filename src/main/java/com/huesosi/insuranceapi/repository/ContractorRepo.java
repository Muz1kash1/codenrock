package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContractorRepo extends JpaRepository<Contractor, UUID> {
}
