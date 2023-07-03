package com.marketplace.api.schemas;

public enum HeaderName {

  AUTHORIZATION("Authorization");

  private final String name;

  HeaderName(String name) {
    this.name = name;
  }
}
