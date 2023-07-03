package com.marketplace.service;

import com.marketplace.enitity.CreditCardData;
import com.marketplace.repository.CreditCardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditCardService {

  private final CreditCardRepo creditCardRepo;
  public CreditCardData create(CreditCardData creditCardData) {
    return creditCardRepo.save(creditCardData);
  }
}
