package com.marketplace.controller.facade;

import com.marketplace.api.dto.product.request.CreateProductCustomerRequest;
import com.marketplace.api.dto.transaction.request.CreateTransactionCustomerRequest;
import com.marketplace.api.dto.product.response.ProductCustomerResponse;
import com.marketplace.api.dto.transaction.response.TransactionCustomerResponse;
import com.marketplace.api.mapper.ProductCustomerMapper;
import com.marketplace.api.mapper.TransactionCustomerMapper;
import com.marketplace.api.service.ApiProductService;
import com.marketplace.api.service.ApiTransactionService;
import com.marketplace.dto.request.CreateCustomerRequest;
import com.marketplace.dto.response.CustomerResponse;
import com.marketplace.enitity.Customer;
import com.marketplace.mapper.CustomerMapper;
import com.marketplace.mapper.StoreCartMapper;
import com.marketplace.service.CustomerService;
import com.marketplace.service.StoreCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerFacade {

  private final CustomerService customerService;
  private final StoreCartService storeCartService;
  private final ApiProductService apiProductService;
  private final ApiTransactionService apiTransactionService;

  private final CustomerMapper customerMapper;
  private final StoreCartMapper storeCartMapper;
  private final ProductCustomerMapper productCustomerMapper;
  private final TransactionCustomerMapper transactionCustomerMapper;

  public CustomerResponse create(CreateCustomerRequest request) {

    CreateTransactionCustomerRequest transactionCustomerRequest =
        transactionCustomerMapper.toRequest(request);
    CreateProductCustomerRequest productCustomerRequest =
        productCustomerMapper.toRequest(request);

    ProductCustomerResponse productCustomerResponse =
        apiProductService.createCustomer(productCustomerRequest);
    TransactionCustomerResponse transactionCustomerResponse =
        apiTransactionService.createCustomer(transactionCustomerRequest);

    Customer customer = customerMapper.toEntity(request, productCustomerResponse, transactionCustomerResponse);
    storeCartService.create(storeCartMapper.toEntity(customer));

    return customerMapper.toDto(customerService.create(customer));
  }
}
