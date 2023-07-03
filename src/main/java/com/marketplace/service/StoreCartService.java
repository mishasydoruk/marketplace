package com.marketplace.service;

import com.marketplace.enitity.Advertisement;
import com.marketplace.enitity.StoreCart;
import com.marketplace.exception.ErrorCode;
import com.marketplace.exception.InternalException;
import com.marketplace.repository.StoreCartRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreCartService {

  private final StoreCartRepo storeCartRepo;

  public StoreCart create(StoreCart storeCart) {
    return storeCartRepo.save(storeCart);
  }

  public StoreCart find(Long id) {
    return storeCartRepo.findById(id)
        .orElseThrow(
            () -> new InternalException(ErrorCode.MRK0010, id)
        );
  }

  public StoreCart add(Advertisement advertisement, StoreCart storeCart) {
    storeCart.getAdvertisements().add(advertisement);
    return storeCartRepo.save(storeCart);
  }
}
