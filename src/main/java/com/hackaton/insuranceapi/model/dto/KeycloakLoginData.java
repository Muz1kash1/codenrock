package com.hackaton.insuranceapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class KeycloakLoginData {
  @JsonProperty("grant_type")
  String grantType = "password";

  @JsonProperty("client_id")
  String clientId;

  @JsonProperty("client_secret")
  String clientSecret;

  String username;
  String password;
}
