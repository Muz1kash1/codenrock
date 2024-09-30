package com.huesosi.insuranceapi.service;

import com.huesosi.insuranceapi.model.core.CalculatedPremiumInfo;
import com.huesosi.insuranceapi.model.core.PremiumCalculationRequest;

public interface InsurancePremiumService {
  CalculatedPremiumInfo calculatePremium(PremiumCalculationRequest request);
}
