package com.marketplace.controller;

import com.marketplace.controller.facade.AdvertisementFacade;
import com.marketplace.dto.response.AdvertisementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/advertisement")
@RequiredArgsConstructor
public class AdvertisementController {

  private final AdvertisementFacade advertisementFacade;

  @PostMapping("/generate")
  public AdvertisementResponse generate(@RequestParam String productReference) {
    return advertisementFacade.generate(productReference);
  }

  @PostMapping("/add/{advertisementId}")
  public AdvertisementResponse add(@PathVariable Long advertisementId, @RequestParam Long cartId) {
    return advertisementFacade.addProduct(advertisementId, cartId);
  }

  @GetMapping("/{id}")
  public AdvertisementResponse find(@PathVariable Long id) {
    return advertisementFacade.find(id);
  }

  @GetMapping()
  public List<AdvertisementResponse> findByCart(@RequestParam Long cartId) {
    return advertisementFacade.findByCartId(cartId);
  }
}
