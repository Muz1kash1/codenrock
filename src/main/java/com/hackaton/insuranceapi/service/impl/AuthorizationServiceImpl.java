package com.hackaton.insuranceapi.service.impl;

import com.hackaton.insuranceapi.feign.KeycloakFeign;
import com.hackaton.insuranceapi.model.core.TokenPair;
import com.hackaton.insuranceapi.model.core.UserCredentials;
import com.hackaton.insuranceapi.model.dto.KeycloakLoginData;
import com.hackaton.insuranceapi.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * {@inheritDoc}
 */
@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {
  private final KeycloakFeign keycloakFeign;
  @Value("${keycloak.client-id}")
  private String keycloakClientId;
  @Value("${keycloak.client-secret}")
  private String keycloakClientSecret;

  /**
   * {@inheritDoc}
   */
  @Override
  public TokenPair login(UserCredentials credentials) {
    KeycloakLoginData loginData = KeycloakLoginData.builder()
        .username(credentials.username())
        .password(credentials.password())
        .clientId(keycloakClientId)
        .clientSecret(keycloakClientSecret)
        .build();

    return keycloakFeign.login(loginData);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public TokenPair logout(Authorization principal) {
    return null;
  }
}
