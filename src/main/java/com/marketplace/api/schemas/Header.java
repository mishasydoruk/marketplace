package com.marketplace.api.schemas;

import lombok.Getter;

@Getter
public class Header {

  private final HeaderName name;

  private final String value;

  public Header(HeaderName name, String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name.toString();
  }
}
