package com.marketplace.enitity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "reference_id")
  private String referenceId;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "params")
  private String params;

  @Column(name = "created_time")
  private Instant createdTime = Instant.now();

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", referenceId='" + referenceId + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", params='" + params + '\'' +
        ", createdTime=" + createdTime +
        '}';
  }
}
