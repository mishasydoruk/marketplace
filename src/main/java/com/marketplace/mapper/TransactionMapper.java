package com.marketplace.mapper;

import com.marketplace.dto.request.CreateTransactionRequest;
import com.marketplace.enitity.Transaction;

public class TransactionMapper {

  public static CreateTransactionRequest toCreateTransactionRequest(Transaction transaction) {
    CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();

    return createTransactionRequest;
  }
}
