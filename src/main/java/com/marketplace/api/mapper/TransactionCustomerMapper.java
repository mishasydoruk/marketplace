package com.marketplace.api.mapper;

import com.marketplace.api.dto.transaction.request.CreateTransactionCustomerRequest;
import com.marketplace.dto.request.CreateCustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class TransactionCustomerMapper {

  public CreateTransactionCustomerRequest toRequest(CreateCustomerRequest createCustomerRequest) {
    CreateTransactionCustomerRequest request = new CreateTransactionCustomerRequest();
    request.setName(createCustomerRequest.getName());
    request.setEmail(createCustomerRequest.getEmail());
    request.setPhone(createCustomerRequest.getPhone());
    return request;
  }
}
