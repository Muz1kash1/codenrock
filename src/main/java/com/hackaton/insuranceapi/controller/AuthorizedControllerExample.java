package com.hackaton.insuranceapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-example")
public class AuthorizedControllerExample {

  /**
   * Кто угодно.
   *
   * @return строка
   */
  @GetMapping("/anyone")
  String anyone() {
    return "You are someone";
  }

  /**
   * Только не авторизированные пользователи.
   *
   * @return строка
   */
  @PreAuthorize("isAnonymous()")
  @GetMapping("/unauthorized")
  String unauthorized() {
    return "You are nothing";
  }

  /**
   * Только авторизированные пользователи.
   *
   * @param user данные о пользователе
   * @return строка
   */
  @PreAuthorize("isAuthenticated()")
  @GetMapping("/authenticated")
  String authenticated(@AuthenticationPrincipal OAuth2User user) {
    return "Hello, " + user.getAttribute("name")
        + ", your email is " + user.getAttribute("email");
  }

  /**
   * Только покупатель.
   *
   * @param user данные о пользователе
   * @return строка
   */
  @PreAuthorize("hasAuthority('CUSTOMER')")
  @GetMapping("/customer")
  String customer(@AuthenticationPrincipal OAuth2User user) {
    return "Hello, customer, " + user.getAttribute("name")
        + ", your email is " + user.getAttribute("email");
  }

  /**
   * Покупатель или Агент.
   *
   * @param user данные о пользователе
   * @return строка
   */
  @PreAuthorize("hasAnyAuthority('CUSTOMER', 'AGENT')")
  @GetMapping("/not-admin")
  String notAdmin(@AuthenticationPrincipal OAuth2User user) {
    return "Hello, customer or agent, " + user.getAttribute("name")
        + ", your email is " + user.getAttribute("email");
  }
}
