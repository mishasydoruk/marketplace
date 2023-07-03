package com.marketplace.controller;

import com.marketplace.controller.facade.ProductFacade;
import com.marketplace.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductFacade productFacade;

  @GetMapping("/search")
  public List<ProductResponse> search(@RequestParam String search) {
    return productFacade.search(search);
  }

}
