package com.marketplace.enitity;

import com.marketplace.enums.AdvertisementStatus;
import com.marketplace.enums.CustomerStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
