package com.marketplace.api.service;

import com.marketplace.api.schemas.RequestParam;
import com.marketplace.api.schemas.RequestPath;
import com.marketplace.api.dto.product.response.ApiProductResponse;
import com.marketplace.api.dto.product.request.CreateProductCustomerRequest;
import com.marketplace.api.dto.product.response.ProductCustomerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ApiProductService extends ApiService {

  public ApiProductService(@Value("${product-service.host}") String baseUrl) {
    super(baseUrl);
  }

  public ProductCustomerResponse createCustomer(CreateProductCustomerRequest request) {
    return createRequest(HttpMethod.POST,
        this.baseUrl.concat(RequestPath.PRODUCT_CREATE_CUSTOMER),
        request,
        Collections.emptyMap(),
        ProductCustomerResponse.class);
  }

  public ApiProductResponse getByReference(String referenceId) {
    return createRequest(
        HttpMethod.GET,
        this.baseUrl.concat(RequestPath.PRODUCT_GET_PRODUCT),
        null,
        Map.of(RequestParam.UUID, referenceId),
        ApiProductResponse.class);
  }

  public List<ApiProductResponse> productSearch(String search) {
    return List.of(createRequest(
        HttpMethod.GET,
        this.baseUrl.concat(RequestPath.PRODUCT_SEARCH),
        null,
        Map.of(RequestParam.SEARCH, search),
        ApiProductResponse[].class));
  }
}
