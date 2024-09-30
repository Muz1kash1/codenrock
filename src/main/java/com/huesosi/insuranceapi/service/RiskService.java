package com.huesosi.insuranceapi.service;

import com.huesosi.insuranceapi.model.core.Risk;
import com.huesosi.insuranceapi.model.core.RiskCreateRequest;
import com.huesosi.insuranceapi.model.enums.RiskFilter;
import java.util.List;
import java.util.UUID;

public interface RiskService {
  List<Risk> getRisks(RiskFilter filter);

  Risk createRisk(RiskCreateRequest risk);

  List<Risk> getRisksByProductId(UUID productId);
}
