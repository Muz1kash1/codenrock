package com.hackaton.insuranceapi.controller;

import com.hackaton.insuranceapi.model.core.CalculatedPremiumInfo;
import com.hackaton.insuranceapi.model.core.PremiumCalculationRequest;
import com.hackaton.insuranceapi.service.InsurancePremiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance-premium")
@RequiredArgsConstructor
class InsurancePremiumController {
  private final InsurancePremiumService insurancePremiumService;

  @PostMapping("/calculate-premium")
  public ResponseEntity<CalculatedPremiumInfo> calculatePremium(@RequestBody
                                                                PremiumCalculationRequest request) {
    return ResponseEntity.ok(insurancePremiumService.calculatePremium(request));
  }
}
