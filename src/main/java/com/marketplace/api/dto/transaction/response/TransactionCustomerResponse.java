package com.marketplace.api.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marketplace.enums.CustomerStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
public class TransactionCustomerResponse {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("uuid")
  private String uuid;

  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("status")
  private CustomerStatus status;

  @JsonProperty("created_time")
  private Instant createdTime;

  @JsonProperty("card_uuids")
  private List<String> cardUuids;
}
