package com.marketplace.api.dto.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@ToString
public class ApiProductResponse {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("uuid")
  private String uuid;

  @JsonProperty("title")
  private String title;

  @JsonProperty("description")
  private String description;

  @JsonProperty("price")
  private BigDecimal price;

  @JsonProperty("params")
  private String params;

  @JsonProperty("created_time")
  private Instant createdTime;

  @JsonProperty("customer_uuid")
  private String customerUuid;
}
