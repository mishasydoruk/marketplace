package com.marketplace.api.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class TransactionCardResponse {

  @JsonProperty("uuid")
  private String uuid;

  @JsonProperty("amount")
  private BigDecimal amount;

  @JsonProperty("number")
  private String number;

  @JsonProperty("status")
  private String status;

  @Override
  public String toString() {
    return "CardResponse{" +
        "uuid='" + uuid + '\'' +
        ", amount=" + amount +
        ", number='" + number + '\'' +
        '}';
  }
}
