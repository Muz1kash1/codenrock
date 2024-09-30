package com.huesosi.insuranceapi.service;

import com.huesosi.insuranceapi.model.core.TokenPair;
import com.huesosi.insuranceapi.model.core.UserCredentials;
import org.apache.tomcat.util.http.parser.Authorization;

public interface AuthorizationService {
  TokenPair login(UserCredentials credentials);

  TokenPair logout(Authorization principal);
}
