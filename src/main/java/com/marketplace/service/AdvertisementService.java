package com.marketplace.service;

import com.marketplace.enitity.Advertisement;
import com.marketplace.exception.ErrorCode;
import com.marketplace.exception.InternalException;
import com.marketplace.repository.AdvertisementRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvertisementService {

  public final AdvertisementRepo advertisementRepo;

  public Advertisement create(Advertisement advertisement) {
    return advertisementRepo.save(advertisement);
  }

  public Optional<Advertisement> findByProductReferenceOptional(String productReference) {
    return advertisementRepo.findByProduct_ReferenceId(productReference);
  }

  public Advertisement findById(Long id) {
    return advertisementRepo.findById(id)
        .orElseThrow(
            () -> new InternalException(ErrorCode.MRK0009, id));
  }
}
