package com.marketplace.api.mapper;

import com.marketplace.api.dto.transaction.request.AddTransactionCardRequest;
import com.marketplace.dto.request.AddCardRequest;
import org.springframework.stereotype.Component;

@Component
public class TransactionCardMapper {

  public AddTransactionCardRequest toRequest(AddCardRequest addCardRequest) {
    AddTransactionCardRequest request = new AddTransactionCardRequest();
    request.setNumber(addCardRequest.getNumber());
    request.setExpireDate(addCardRequest.getExpireDate());
    request.setCvv(addCardRequest.getCvv());
    return request;
  }
}
