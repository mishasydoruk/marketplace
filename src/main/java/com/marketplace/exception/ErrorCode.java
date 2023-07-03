package com.marketplace.exception;

public enum ErrorCode {
  MRK0000("Something went wrong . The error is"),
  MRK0001("Could not send request to %s . The error is %s"),
  MRK0002("Could not parse response . The error is %s"),
  MRK0003("Cannot find transaction by id = '%s'"),
  MRK0004("Cannot get response from http request, the code is '%s', body is '%s'"),
  MRK0005("Cannot build url, the error is '%s'"),
  MRK0006("Cannot get send http request, the error is '%s'"),
  MRK0007("Cannot find customer by product reference '%s'"),
  MRK0008("Cannot find customer by transaction reference '%s'"),
  MRK0009("Cannot find advertisement by id '%s'"),
  MRK0010("Cannot find store cart by id '%s'"),
  MRK0011("Cannot find customer by id '%s'");

  private final String message;

  ErrorCode(String message) {
    this.message = message;
  }

  public String getMessage(Object... args) {
    return String.format(this.message, args);
  }

  public String getCode() {
    return this.name();
  }
}
