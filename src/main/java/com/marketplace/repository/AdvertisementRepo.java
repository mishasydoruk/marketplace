package com.marketplace.repository;

import com.marketplace.enitity.Advertisement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertisementRepo extends CrudRepository<Advertisement, Long> {

  Optional<Advertisement> findByProduct_ReferenceId(String referenceId);
}
