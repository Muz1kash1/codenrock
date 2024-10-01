package com.hackaton.insuranceapi.controller;

import com.hackaton.insuranceapi.model.core.TokenPair;
import com.hackaton.insuranceapi.model.core.UserCredentials;
import com.hackaton.insuranceapi.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthorizationService authorizationService;

  @PostMapping("/login")
  public ResponseEntity<TokenPair> login(@RequestBody UserCredentials credentials) {
    return ResponseEntity.ok(authorizationService.login(credentials));
  }

  @PostMapping("/logout")
  public ResponseEntity<Void> logout(Authorization principal) {
    authorizationService.logout(principal);
    return ResponseEntity.noContent().build();
  }
}
