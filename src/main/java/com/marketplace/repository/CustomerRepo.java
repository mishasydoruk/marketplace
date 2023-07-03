package com.marketplace.repository;

import com.marketplace.enitity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {

  Optional<Customer> findByProductServiceReference(String productServiceReference);
}
