package com.hackaton.insuranceapi.service;

import com.hackaton.insuranceapi.model.core.InsuranceProduct;
import com.hackaton.insuranceapi.model.core.InsuranceProductCreateRequest;
import com.hackaton.insuranceapi.model.enums.FilterParameters;
import java.util.List;
import java.util.UUID;

public interface InsuranceProductService {
  List<InsuranceProduct> getInsuranceProductsFiltered(FilterParameters filter);

  InsuranceProduct getInsuranceProductById(UUID productId);

  InsuranceProduct createInsuranceProduct(InsuranceProductCreateRequest request);

  InsuranceProduct cloneInsuranceProduct(UUID productId);
}
