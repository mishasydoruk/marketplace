package com.marketplace.api.mapper;

import com.marketplace.api.dto.product.request.CreateProductCustomerRequest;
import com.marketplace.dto.request.CreateCustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductCustomerMapper {

  public CreateProductCustomerRequest toRequest(CreateCustomerRequest createCustomerRequest) {
    CreateProductCustomerRequest request = new CreateProductCustomerRequest();
    request.setName(createCustomerRequest.getName());
    request.setEmail(createCustomerRequest.getEmail());
    request.setPhone(createCustomerRequest.getPhone());
    return request;
  }
}
