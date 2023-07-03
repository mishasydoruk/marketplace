package com.marketplace.mapper;

import com.marketplace.api.dto.product.response.ProductCustomerResponse;
import com.marketplace.api.dto.transaction.response.TransactionCustomerResponse;
import com.marketplace.dto.request.CreateCustomerRequest;
import com.marketplace.dto.response.CustomerResponse;
import com.marketplace.enitity.Customer;
import com.marketplace.enums.CustomerStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
  public Customer toEntity(CreateCustomerRequest request,
                           ProductCustomerResponse productCustomerResponse,
                           TransactionCustomerResponse transactionCustomerResponse) {
    Customer customer = new Customer();
    customer.setName(request.getName());
    customer.setEmail(request.getEmail());
    customer.setPhone(request.getPhone());
    customer.setStatus(CustomerStatus.ACTIVE);
    customer.setProductServiceReference(productCustomerResponse.getUuid());
    customer.setTransactionServiceReference(transactionCustomerResponse.getUuid());
    return customer;
  }

  public CustomerResponse toDto(Customer customer) {
    CustomerResponse response = new CustomerResponse();
    response.setId(customer.getId());
    response.setProductServiceReference(customer.getProductServiceReference());
    response.setTransactionServiceReference(customer.getTransactionServiceReference());
    response.setName(customer.getName());
    response.setEmail(customer.getEmail());
    response.setPhone(customer.getPhone());
    response.setStatus(customer.getStatus());
    response.setCreatedTime(customer.getCreatedTime());
    return response;
  }

}
