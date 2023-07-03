package com.marketplace.exception;

public class InternalException extends RuntimeException {

  private final String code;

  public InternalException(ErrorCode errorCode, Object... args) {
    super(errorCode.getMessage(args));
    this.code = errorCode.getCode();
  }

  public String getCode() {
    return code;
  }
}
