package com.marketplace.api.dto.transaction.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AddTransactionCardRequest {

  private String number;
  private String expireDate;
  private String cvv;

  @Override
  public String toString() {
    return "AddCardRequest{" +
        "number='" + number.replaceFirst(".{12}$", "*") + '\'' +
        ", expireDate='" + expireDate + '\'' +
        '}';
  }
}
