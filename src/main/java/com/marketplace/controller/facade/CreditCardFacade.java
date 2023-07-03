package com.marketplace.controller.facade;

import com.marketplace.api.dto.transaction.response.TransactionCardResponse;
import com.marketplace.api.mapper.TransactionCardMapper;
import com.marketplace.api.service.ApiTransactionService;
import com.marketplace.dto.request.AddCardRequest;
import com.marketplace.dto.response.CardResponse;
import com.marketplace.enitity.Customer;
import com.marketplace.mapper.CreditCardMapper;
import com.marketplace.service.CreditCardService;
import com.marketplace.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditCardFacade {

  private final CreditCardService creditCardService;
  private final CustomerService customerService;
  private final ApiTransactionService apiTransactionService;

  private final CreditCardMapper creditCardMapper;
  private final TransactionCardMapper transactionCardMapper;

  public CardResponse create(AddCardRequest request, Long customerId) {
    Customer customer = customerService.findById(customerId);
    TransactionCardResponse transactionCardResponse = apiTransactionService
        .addCard(transactionCardMapper.toRequest(request), customer.getTransactionServiceReference());

    return creditCardMapper.toDto(
        creditCardService.create(creditCardMapper.toEntity(transactionCardResponse, customer)));
  }
}
