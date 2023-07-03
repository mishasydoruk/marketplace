package com.marketplace.controller.facade;

import com.marketplace.api.dto.product.response.ApiProductResponse;
import com.marketplace.api.service.ApiProductService;
import com.marketplace.dto.response.AdvertisementResponse;
import com.marketplace.enitity.Advertisement;
import com.marketplace.enitity.Customer;
import com.marketplace.enitity.Product;
import com.marketplace.enitity.StoreCart;
import com.marketplace.mapper.AdvertisementMapper;
import com.marketplace.mapper.ProductMapper;
import com.marketplace.service.AdvertisementService;
import com.marketplace.service.CustomerService;
import com.marketplace.service.ProductService;
import com.marketplace.service.StoreCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AdvertisementFacade {

  private final ApiProductService apiProductService;

  private final AdvertisementService advertisementService;
  private final CustomerService customerService;
  private final ProductService productService;
  private final StoreCartService storeCartService;

  private final AdvertisementMapper advertisementMapper;
  private final ProductMapper productMapper;

  public AdvertisementResponse generate(String productReference) {

    Optional<Advertisement> optionalAdvertisement = advertisementService
        .findByProductReferenceOptional(productReference);

    if (optionalAdvertisement.isPresent()) {
      return advertisementMapper.toDto(optionalAdvertisement.get());
    }

    ApiProductResponse apiProductResponse = apiProductService.getByReference(productReference);
    Customer customer = customerService.findByProductReference(apiProductResponse.getCustomerUuid());
    Product product = productService.create(productMapper.toEntity(apiProductResponse, customer));

    Advertisement advertisement = advertisementMapper.toEntity(product);
    return advertisementMapper.toDto(advertisementService.create(advertisement));
  }

  public AdvertisementResponse find(Long id) {
    return advertisementMapper.toDto(advertisementService.findById(id));
  }

  public List<AdvertisementResponse> findByCartId(Long cartId) {
    StoreCart storeCart = storeCartService.find(cartId);
    return advertisementMapper.toDto(storeCart.getAdvertisements());
  }

  public AdvertisementResponse addProduct(Long advertisementId, Long cartId) {
    StoreCart storeCart = storeCartService.find(cartId);
    Advertisement advertisement = advertisementService.findById(advertisementId);
    storeCartService.add(advertisement, storeCart);
    return advertisementMapper.toDto(advertisement);
  }
}
