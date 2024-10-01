package com.hackaton.insuranceapi.service;

import com.hackaton.insuranceapi.model.core.TokenPair;
import com.hackaton.insuranceapi.model.core.UserCredentials;
import org.apache.tomcat.util.http.parser.Authorization;

public interface AuthorizationService {
  TokenPair login(UserCredentials credentials);

  TokenPair logout(Authorization principal);
}
