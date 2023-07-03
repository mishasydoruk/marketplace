package com.marketplace.controller;

import com.marketplace.controller.facade.CreditCardFacade;
import com.marketplace.dto.request.AddCardRequest;
import com.marketplace.dto.response.CardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CreditCardController {

  private final CreditCardFacade creditCardFacade;

  @PostMapping()
  public CardResponse create(
      @RequestBody AddCardRequest request,
      @RequestParam Long customerId) {
    return creditCardFacade.create(request, customerId);
  }

}
