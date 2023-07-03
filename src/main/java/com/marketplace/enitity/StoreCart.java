package com.marketplace.enitity;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

  @ManyToMany(targetEntity = Advertisement.class, fetch = FetchType.LAZY)
  @JoinTable(name = "cart_to_advertisements",
      joinColumns = {@JoinColumn(name = "store_cart_id")},
      inverseJoinColumns = {@JoinColumn(name = "advertisement_id")}
  )
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
