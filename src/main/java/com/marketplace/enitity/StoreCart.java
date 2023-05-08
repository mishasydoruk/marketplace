package com.marketplace.enitity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "store_cart")
@Getter
@Setter
public class StoreCart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @ManyToOne(targetEntity = Advertisement.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "advertisement_id", referencedColumnName = "id", nullable = false)
  private Set<Advertisement> advertisements;

  @Column(name = "created_time")
  private Instant createdTime = Instant.now();

  @Override
  public String toString() {
    return "StoreCart{" +
        "id=" + id +
        ", customer=" + customer +
        ", createdTime=" + createdTime +
        '}';
  }
}
