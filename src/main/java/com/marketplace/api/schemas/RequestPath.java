package com.marketplace.api.schemas;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestPath {

  //Product service
  public static final String PRODUCT_CREATE_CUSTOMER = "/customer";
  public static final String PRODUCT_GET_CUSTOMER = "/customer";
  public static final String PRODUCT_SEARCH = "/product/search";
  public static final String PRODUCT_GET_PRODUCT = "/product";


  //Transaction servise
  public static final String TRANSACTION_CREATE_CUSTOMER = "/customer";
  public static final String TRANSACTION_GET_CUSTOMER = "/customer";
  public static final String TRANSACTION_ADD_CARD = "/card";

}
