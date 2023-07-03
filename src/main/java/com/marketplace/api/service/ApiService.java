package com.marketplace.api.service;

import com.marketplace.exception.ErrorCode;
import com.marketplace.exception.InternalException;
import com.marketplace.api.schemas.Header;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public abstract class ApiService {

  private final RestTemplate restTemplate = new RestTemplate();

  protected final String baseUrl;

  public <T> T createRequest(
      HttpMethod method,
      String url,
      Object body,
      Map<String, String> params,
      Class<T> returnType,
      Header... headers) {

    try {
      HttpHeaders httpHeaders = new HttpHeaders();
      for (Header header : headers) {
        httpHeaders.add(header.getName(), header.getValue());
      }

      HttpEntity<?> requestEntity = new HttpEntity<>(body, httpHeaders);

      URIBuilder uriBuilder = new URIBuilder(url);
      for (Map.Entry<String, String> entry : params.entrySet()) {
        uriBuilder.addParameter(entry.getKey(), entry.getValue()).build();
      }
      url = uriBuilder.build().toString();

      ResponseEntity<T> response =
          restTemplate.exchange(url, method, requestEntity, returnType, params);

      if (response.getStatusCode().is2xxSuccessful()) {
        return response.getBody();
      } else {
        throw new InternalException(ErrorCode.MRK0004, response.getStatusCode(), response.getBody());
      }
    } catch (RestClientException ex) {
      throw new InternalException(ErrorCode.MRK0006, ex.getMessage());
    } catch (URISyntaxException ex) {
      throw new InternalException(ErrorCode.MRK0005, ex.getMessage());
    }
  }
}
