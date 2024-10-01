package com.hackaton.insuranceapi.config;

import com.nimbusds.jose.shaded.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Autowired
  @Bean
  public SecurityFilterChain configure(HttpSecurity http, JwtAuthenticationConverter converter) throws Exception {
    http.oauth2ResourceServer(config -> config
        .jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(converter)));
    return http.build();
  }

  @Bean
  public JwtAuthenticationConverter jwtAuthenticationConverterForKeycloak() {
    Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter = jwt -> {
      Map<String, Object> resourceAccess = jwt.getClaim("resource_access");

      Object client = resourceAccess.get("external-client");

      LinkedTreeMap<String, List<String>> clientRoleMap = (LinkedTreeMap<String, List<String>>) client;

      List<String> clientRoles = new ArrayList<>(clientRoleMap.get("roles"));

      return clientRoles.stream()
          .map(SimpleGrantedAuthority::new)
          .collect(Collectors.toList());
    };

    JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();

    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);

    return jwtAuthenticationConverter;
  }
}
