package com.huesosi.insuranceapi.service;

import com.huesosi.insuranceapi.model.core.InsuranceProduct;
import com.huesosi.insuranceapi.model.core.InsuranceProductCreateRequest;
import com.huesosi.insuranceapi.model.enums.FilterParameters;
import java.util.List;
import java.util.UUID;

public interface InsuranceProductService {
  List<InsuranceProduct> getInsuranceProductsFiltered(FilterParameters filter);

  InsuranceProduct getInsuranceProductById(UUID productId);

  InsuranceProduct createInsuranceProduct(InsuranceProductCreateRequest request);

  InsuranceProduct cloneInsuranceProduct(UUID productId);
}
