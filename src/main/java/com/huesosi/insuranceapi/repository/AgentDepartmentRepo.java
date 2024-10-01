package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.AgentDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentDepartmentRepo extends JpaRepository<AgentDepartment, Integer> {
}
