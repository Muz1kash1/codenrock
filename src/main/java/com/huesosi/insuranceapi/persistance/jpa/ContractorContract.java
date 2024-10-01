package com.huesosi.insuranceapi.persistance.jpa;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ContractorContract {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "contractor_id", nullable = false)
    private Contractor contractor;

    @ManyToOne
    @JoinColumn(name = "insurance_contract_id", nullable = false)
    private InsuranceContract insuranceContract;

    @ManyToOne
    @JoinColumn(name = "insurant_type_id", nullable = false)
    private InsurantType insurantType;

}
