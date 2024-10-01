package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgentRepo extends JpaRepository<Agent, UUID> {
}
