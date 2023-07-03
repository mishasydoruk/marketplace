package com.marketplace.controller.facade;

import com.marketplace.api.dto.product.response.ApiProductResponse;
import com.marketplace.api.service.ApiProductService;
import com.marketplace.dto.response.ProductResponse;
import com.marketplace.mapper.ProductMapper;
import com.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductFacade {

  private final ApiProductService apiProductService;

  private final ProductService productService;
  private final ProductMapper productMapper;

  public List<ProductResponse> search(String search) {
    List<ApiProductResponse> products = apiProductService.productSearch(search);
    return productMapper.toDto(products);
  }
}
