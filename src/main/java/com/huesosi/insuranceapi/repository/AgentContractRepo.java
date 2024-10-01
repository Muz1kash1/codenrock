package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.AgentContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgentContractRepo extends JpaRepository<AgentContract, UUID> {
}
