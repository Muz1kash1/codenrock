package com.hackaton.insuranceapi.service;

import com.hackaton.insuranceapi.model.core.TokenPair;
import com.hackaton.insuranceapi.model.core.UserCredentials;
import org.apache.tomcat.util.http.parser.Authorization;

/**
 * Сервис авторизации в нашем Keycloak.
 */
public interface AuthorizationService {
  /**
   * Получить пару токенов.
   *
   * @param credentials данные пользователя
   * @return пара токенов
   */
  TokenPair login(UserCredentials credentials);

  /**
   * Инвалидировать пару токенов.
   *
   * @param principal сессия
   * @return пара токенов
   */
  TokenPair logout(Authorization principal);
}
