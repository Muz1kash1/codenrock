package com.hackaton.insuranceapi.service;

import com.hackaton.insuranceapi.model.core.CalculatedPremiumInfo;
import com.hackaton.insuranceapi.model.core.PremiumCalculationRequest;

public interface InsurancePremiumService {
  CalculatedPremiumInfo calculatePremium(PremiumCalculationRequest request);
}
