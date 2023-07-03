package com.marketplace.api.service;

import com.marketplace.api.dto.transaction.request.AddTransactionCardRequest;
import com.marketplace.api.dto.transaction.response.TransactionCardResponse;
import com.marketplace.api.schemas.RequestParam;
import com.marketplace.api.schemas.RequestPath;
import com.marketplace.api.dto.transaction.request.CreateTransactionCustomerRequest;
import com.marketplace.api.dto.transaction.response.TransactionCustomerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class ApiTransactionService extends ApiService {

  public ApiTransactionService( @Value("${transaction-service.host}") String baseUrl) {
    super(baseUrl);
  }

  public TransactionCustomerResponse createCustomer(CreateTransactionCustomerRequest request) {

    return createRequest(HttpMethod.POST,
        this.baseUrl.concat(RequestPath.TRANSACTION_CREATE_CUSTOMER),
        request,
        Collections.emptyMap(),
        TransactionCustomerResponse.class);
  }

  public TransactionCardResponse addCard(AddTransactionCardRequest request, String customerReference) {
    return createRequest(HttpMethod.POST,
        this.baseUrl.concat(RequestPath.TRANSACTION_ADD_CARD),
        request,
        Map.of(RequestParam.CUSTOMER_UUID, customerReference),
        TransactionCardResponse.class);
  }
}
