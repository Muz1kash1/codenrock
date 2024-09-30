package com.huesosi.insuranceapi.controller;

import com.huesosi.insuranceapi.model.core.Risk;
import com.huesosi.insuranceapi.model.core.RiskCreateRequest;
import com.huesosi.insuranceapi.model.enums.RiskFilter;
import com.huesosi.insuranceapi.service.RiskService;
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

@PreAuthorize("hasRole(agent)")
@RestController
@RequiredArgsConstructor
@RequestMapping("/risks")
public class RiskController {
  private final RiskService riskService;

  @GetMapping
  public ResponseEntity<List<Risk>> getRisks(@RequestParam("filter") RiskFilter filter) {
    return ResponseEntity.ok(riskService.getRisks(filter));
  }

  @GetMapping("/products/{productId}")
  public ResponseEntity<List<Risk>> getRisksByProductId(@PathVariable("productId") UUID productId) {
    return ResponseEntity.ok(riskService.getRisksByProductId(productId));
  }

  @PostMapping
  public ResponseEntity<Risk> createRisk(@RequestBody RiskCreateRequest risk) {
    return ResponseEntity.ok(riskService.createRisk(risk));
  }
}
