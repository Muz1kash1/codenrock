package com.hackaton.insuranceapi.config;

import com.hackaton.insuranceapi.util.RestApiException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

public class FeignConfig {
  @Bean
  public ErrorDecoder errorDecoder() {
    return new CustomErrorDecoder();
  }

  public static class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
      String requestUrl = response.request().url();
      Response.Body responseBody = response.body();
      HttpStatus responseStatus = HttpStatus.valueOf(response.status());

      if (responseStatus.is5xxServerError()) {
        return new RestApiException.RestApiServerException(responseStatus, responseBody, requestUrl);
      } else if (responseStatus.is4xxClientError()) {
        return new RestApiException.RestApiClientException(responseStatus, responseBody, requestUrl);
      } else {
        return new Exception("Something went wrong during Feign request");
      }
    }
  }
}
