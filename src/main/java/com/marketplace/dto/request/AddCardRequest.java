package com.marketplace.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddCardRequest {

  private final String number;
  private final String expireDate;
  private final String cvv;

  @Override
  public String toString() {
    return "AddCardRequest{" +
        "number='" + number.replaceFirst(".{12}$", "*") + '\'' +
        ", expireDate='" + expireDate + '\'' +
        '}';
  }
}
