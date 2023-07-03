package com.marketplace.enitity;

import com.marketplace.enums.AdvertisementStatus;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "advertisement")
@Getter
@Setter
public class Advertisement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private AdvertisementStatus status;

  @Column(name = "created_time")
  private Instant createdTime = Instant.now();

  @Override
  public String toString() {
    return "Advertisement{" +
        "id=" + id +
        ", product=" + product +
        ", price=" + price +
        ", status=" + status +
        ", createdTime=" + createdTime +
        '}';
  }
}
