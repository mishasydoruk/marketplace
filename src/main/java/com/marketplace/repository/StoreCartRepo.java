package com.marketplace.repository;

import com.marketplace.enitity.StoreCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreCartRepo extends CrudRepository<StoreCart, Long> {
}
