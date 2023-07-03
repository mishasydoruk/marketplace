package com.marketplace.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.marketplace.enums.CustomerStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustomerResponse {

  private Long id;
  private String productServiceReference;
  private String transactionServiceReference;
  private String name;
  private String email;
  private String phone;
  private CustomerStatus status;
  private Instant createdTime;
}
