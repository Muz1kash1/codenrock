package com.huesosi.insuranceapi.persistance.jpa;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InsuranceContract {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "insurance_contract_id")
    private UUID id;

    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime signingDate;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private double insurancePremium;

    @Column(nullable = false)
    private double insuranceAmount;

    // todo расчитать эти 2 полня на основе других
    private float commissionRate;
    private float commissionAmount;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductInsurance insuranceProduct;

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private StatusContract status;
}