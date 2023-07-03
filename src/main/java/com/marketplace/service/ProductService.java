package com.marketplace.service;

import com.marketplace.enitity.Product;
import com.marketplace.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepo productRepo;

  public Product create(Product product) {
    return productRepo.save(product);
  }
}
