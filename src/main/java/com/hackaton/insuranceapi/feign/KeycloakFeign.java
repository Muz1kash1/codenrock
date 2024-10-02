package com.hackaton.insuranceapi.feign;

import com.hackaton.insuranceapi.config.FeignConfig;
import com.hackaton.insuranceapi.model.core.TokenPair;
import com.hackaton.insuranceapi.model.dto.KeycloakLoginData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "keycloak", url = "${keycloak.url}", configuration = FeignConfig.class)
public interface KeycloakFeign {
  @PostMapping(value="/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  TokenPair login(@RequestBody KeycloakLoginData loginData);
}
