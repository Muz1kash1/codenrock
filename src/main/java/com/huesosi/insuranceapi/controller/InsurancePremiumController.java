package com.huesosi.insuranceapi.controller;

import com.huesosi.insuranceapi.model.core.CalculatedPremiumInfo;
import com.huesosi.insuranceapi.model.core.PremiumCalculationRequest;
import com.huesosi.insuranceapi.service.InsurancePremiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance-premium")
@RequiredArgsConstructor
public class InsurancePremiumController {
    private final InsurancePremiumService insurancePremiumService;

    @PostMapping("/calculate-premium")
    public ResponseEntity<CalculatedPremiumInfo> calculatePremium(@RequestBody
                                                                  PremiumCalculationRequest request) {
        return ResponseEntity.ok(insurancePremiumService.calculatePremium(request));
    }
}
