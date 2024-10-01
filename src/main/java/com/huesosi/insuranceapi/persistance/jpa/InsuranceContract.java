package com.huesosi.insuranceapi.persistance.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InsuranceContract {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "insurance_contract_id")
    private UUID id;

    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime signingDate;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private BigDecimal insurancePremium;

    @Column(nullable = false)
    private BigDecimal insuranceAmount;

    @Column(nullable = true)
    private BigDecimal commissionRate;

    @Column(nullable = true)
    private BigDecimal commissionAmount;

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