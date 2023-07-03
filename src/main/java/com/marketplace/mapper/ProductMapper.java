package com.marketplace.mapper;

import com.marketplace.api.dto.product.response.ApiProductResponse;
import com.marketplace.dto.response.ProductResponse;
import com.marketplace.enitity.Customer;
import com.marketplace.enitity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

  public Product toEntity(ApiProductResponse apiProductResponse, Customer customer) {
    Product product = new Product();
    product.setTitle(apiProductResponse.getTitle());
    product.setDescription(apiProductResponse.getDescription());
    product.setPrice(apiProductResponse.getPrice());
    product.setReferenceId(apiProductResponse.getUuid());
    product.setCustomer(customer);
    product.setParams(apiProductResponse.getParams());
    return product;
  }

  public Product toEntity(Product product, ApiProductResponse apiProductResponse) {
    product.setTitle(apiProductResponse.getTitle());
    product.setDescription(apiProductResponse.getDescription());
    product.setPrice(apiProductResponse.getPrice());
    product.setReferenceId(apiProductResponse.getUuid());
    product.setParams(apiProductResponse.getParams());
    return product;
  }

  public ProductResponse toDto(ApiProductResponse apiProductResponse) {
    ProductResponse productResponse = new ProductResponse();
    productResponse.setReferenceId(apiProductResponse.getUuid());
    productResponse.setDescription(apiProductResponse.getDescription());
    productResponse.setTitle(apiProductResponse.getTitle());
    productResponse.setParams(apiProductResponse.getParams());
    productResponse.setCreatedTime(apiProductResponse.getCreatedTime());
    productResponse.setPrice(apiProductResponse.getPrice());
    return productResponse;
  }

  public List<ProductResponse> toDto(List<ApiProductResponse> apiProductResponse) {
    return apiProductResponse.stream()
        .map(this::toDto)
        .collect(Collectors.toList());
  }

  public ProductResponse toDtoIgnorePrice(Product product) {
    ProductResponse productResponse = new ProductResponse();
    productResponse.setReferenceId(product.getReferenceId());
    productResponse.setDescription(product.getDescription());
    productResponse.setTitle(product.getTitle());
    productResponse.setParams(product.getParams());
    productResponse.setCreatedTime(product.getCreatedTime());
    return productResponse;
  }
}
