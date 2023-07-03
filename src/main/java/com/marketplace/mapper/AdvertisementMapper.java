package com.marketplace.mapper;

import com.marketplace.dto.response.AdvertisementResponse;
import com.marketplace.enitity.Advertisement;
import com.marketplace.enitity.Product;
import com.marketplace.enums.AdvertisementStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdvertisementMapper {

  private static final BigDecimal FEE_AMOUNT = BigDecimal.valueOf(5.90);

  private final ProductMapper productMapper;

  public Advertisement toEntity(Product product) {
    Advertisement advertisement = new Advertisement();
    advertisement.setPrice(product.getPrice().add(FEE_AMOUNT));
    advertisement.setStatus(AdvertisementStatus.ACTIVE);
    advertisement.setProduct(product);
    return advertisement;
  }

  public AdvertisementResponse toDto(Advertisement advertisement) {
    AdvertisementResponse response = new AdvertisementResponse();
    response.setId(advertisement.getId());
    response.setCreatedTime(advertisement.getCreatedTime());
    response.setStatus(advertisement.getStatus());
    response.setPrice(advertisement.getPrice());
    response.setProduct(productMapper.toDtoIgnorePrice(advertisement.getProduct()));
    return response;
  }

  public List<AdvertisementResponse> toDto(Collection<Advertisement> advertisements) {
    return advertisements.stream()
        .map(this::toDto)
        .collect(Collectors.toList());
  }
}
