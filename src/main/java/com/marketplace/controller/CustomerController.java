package com.marketplace.controller;

import com.marketplace.controller.facade.CustomerFacade;
import com.marketplace.dto.request.CreateCustomerRequest;
import com.marketplace.dto.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerFacade customerFacade;

  @PostMapping
  public CustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) {
    return customerFacade.create(request);
  }
}
