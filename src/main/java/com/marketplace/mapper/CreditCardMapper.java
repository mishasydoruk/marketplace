package com.marketplace.mapper;

import com.marketplace.api.dto.transaction.response.TransactionCardResponse;
import com.marketplace.dto.response.CardResponse;
import com.marketplace.enitity.CreditCardData;
import com.marketplace.enitity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper {

  public CreditCardData toEntity(TransactionCardResponse response, Customer customer) {
    CreditCardData creditCardData = new CreditCardData();
    creditCardData.setReferenceId(response.getUuid());
    creditCardData.setNumber(response.getNumber());
    creditCardData.setCustomer(customer);
    return creditCardData;
  }

  public CardResponse toDto(CreditCardData creditCardData) {
    CardResponse response = new CardResponse();
    response.setReferenceId(creditCardData.getReferenceId());
    response.setNumber(creditCardData.getNumber().replaceFirst(".{12}$", "*"));
    return response;
  }
}
