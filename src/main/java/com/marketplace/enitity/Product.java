package com.marketplace.enitity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "params")
  private String params;

  @Column(name = "created_time")
  private Instant createdTime = Instant.now();

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", referenceId='" + referenceId + '\'' +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", params='" + params + '\'' +
        ", createdTime=" + createdTime +
        '}';
  }
}
