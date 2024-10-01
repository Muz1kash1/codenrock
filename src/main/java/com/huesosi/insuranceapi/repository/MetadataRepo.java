package com.huesosi.insuranceapi.repository;

import com.huesosi.insuranceapi.persistance.jpa.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetadataRepo extends JpaRepository<Metadata, Integer> {
}
