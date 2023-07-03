package com.marketplace.mapper;

import com.marketplace.enitity.Customer;
import com.marketplace.enitity.StoreCart;
import org.springframework.stereotype.Component;

@Component
public class StoreCartMapper {

  public StoreCart toEntity(Customer customer) {
    StoreCart storeCart = new StoreCart();
    storeCart.setCustomer(customer);
    return storeCart;
  }
}
