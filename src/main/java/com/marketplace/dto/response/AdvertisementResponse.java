package com.marketplace.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.marketplace.enums.AdvertisementStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AdvertisementResponse {

  private Long id;

  private ProductResponse product;

  private BigDecimal price;

  private AdvertisementStatus status;

  private Instant createdTime;
}
