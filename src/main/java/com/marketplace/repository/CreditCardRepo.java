package com.marketplace.repository;

import com.marketplace.enitity.CreditCardData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepo extends CrudRepository<CreditCardData, Long> {
}
