package com.hackaton.insuranceapi.model.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenPair {
  @JsonProperty("access_token")
  String accessToken;
  @JsonProperty("refresh_token")
  String refreshToken;
}
