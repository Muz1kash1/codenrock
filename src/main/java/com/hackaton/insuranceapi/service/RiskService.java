package com.hackaton.insuranceapi.service;

import com.hackaton.insuranceapi.model.core.Risk;
import com.hackaton.insuranceapi.model.core.RiskCreateRequest;
import com.hackaton.insuranceapi.model.enums.RiskFilter;
import java.util.List;
import java.util.UUID;

public interface RiskService {
  List<Risk> getRisks(RiskFilter filter);

  Risk createRisk(RiskCreateRequest risk);

  List<Risk> getRisksByProductId(UUID productId);
}
