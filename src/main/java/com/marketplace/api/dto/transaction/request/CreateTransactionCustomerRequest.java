package com.marketplace.api.dto.transaction.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTransactionCustomerRequest {

  private String name;
  private String email;
  private String phone;

  @Override
  public String toString() {
    return "CreateCustomerRequest{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        '}';
  }

}
