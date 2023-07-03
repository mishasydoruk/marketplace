package com.marketplace.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateCustomerRequest {

  private final String name;
  private final String email;
  private final String phone;

  @Override
  public String toString() {
    return "CreateCustomerRequest{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        '}';
  }
}
