package com.marketplace.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CardResponse {

  private String referenceId;
  private String number;

  @Override
  public String toString() {
    return "CardResponse{" +
        "uuid='" + referenceId + '\'' +
        ", number='" + number + '\'' +
        '}';
  }
}
