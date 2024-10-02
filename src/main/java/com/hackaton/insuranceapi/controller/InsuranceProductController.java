package com.hackaton.insuranceapi.controller;

import com.hackaton.insuranceapi.model.core.InsuranceProduct;
import com.hackaton.insuranceapi.model.core.InsuranceProductCreateRequest;
import com.hackaton.insuranceapi.model.enums.FilterParameters;
import com.hackaton.insuranceapi.service.InsuranceProductService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance-products")
@RequiredArgsConstructor
class InsuranceProductController {
  private final InsuranceProductService insuranceProductService;

  @GetMapping
  public ResponseEntity<List<InsuranceProduct>> getInsuranceProducts(
      @RequestParam("filter") FilterParameters filter) {
    return ResponseEntity.ok(insuranceProductService.getInsuranceProductsFiltered(filter));
  }

  @GetMapping("/{productId}")
  public ResponseEntity<InsuranceProduct> getInsuranceProduct(
      @PathVariable("productId") UUID productId) {
    return ResponseEntity.ok(insuranceProductService.getInsuranceProductById(productId));
  }

  @PreAuthorize("hasRole(agent)")
  @PostMapping
  public ResponseEntity<InsuranceProduct> createInsuranceProduct(@RequestBody
                                                                 InsuranceProductCreateRequest request) {
    return ResponseEntity.ok(insuranceProductService.createInsuranceProduct(request));
  }

  @PreAuthorize("hasRole(agent)")
  @PostMapping("/{productId}/clone")
  public ResponseEntity<InsuranceProduct> cloneInsuranceProduct(
      @PathVariable("productId") UUID productId) {
    return ResponseEntity.ok(insuranceProductService.cloneInsuranceProduct(productId));
  }
}
