package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.InsurantType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurantTypeRepo extends JpaRepository<InsurantType, Integer> {
}
