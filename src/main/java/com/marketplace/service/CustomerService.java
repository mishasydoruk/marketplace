package com.marketplace.service;

import com.marketplace.enitity.Customer;
import com.marketplace.exception.ErrorCode;
import com.marketplace.exception.InternalException;
import com.marketplace.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepo customerRepo;

  public Customer create(Customer customer) {
    return customerRepo.save(customer);
  }

  public Customer findById(Long id) {
    return customerRepo.findById(id)
        .orElseThrow(
            () -> new InternalException(ErrorCode.MRK0011, id));
  }

  public Customer findByProductReference(String productReference) {
    return customerRepo.findByProductServiceReference(productReference)
        .orElseThrow(
            () -> new InternalException(ErrorCode.MRK0007, productReference));
  }
}
