package com.hackaton.insuranceapi.util;

import feign.Response;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestApiException extends Exception {
  private final HttpStatus statusCode;
  private final Response.Body body;
  private final String requestUrl;

  public RestApiException(HttpStatus statusCode, Response.Body body, String requestUrl) {
    super(String.format("Feign request to %s failed with code %s and returned %s", requestUrl, statusCode, body));
    this.statusCode = statusCode;
    this.body = body;
    this.requestUrl = requestUrl;
  }

  public static class RestApiClientException extends RestApiException {
    public RestApiClientException(HttpStatus statusCode, Response.Body body, String requestUrl) {
      super(statusCode, body, requestUrl);
    }
  }

  public static class RestApiServerException extends RestApiException {
    public RestApiServerException(HttpStatus statusCode, Response.Body body, String requestUrl) {
      super(statusCode, body, requestUrl);
    }
  }
}
