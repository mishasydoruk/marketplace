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
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "credit_card_data")
@Getter
@Setter
public class CreditCardData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
  private Customer customer;

  @Column(name = "number")
  private String number;

  @Column(name = "expire_date")
  private String expireDate;

  @Column(name = "cvv")
  private String cvv;

  @Column(name = "created_time")
  private Instant createdTime = Instant.now();

  @Override
  public String toString() {
    return "CreditCardData{" +
        "id=" + id +
        ", customer=" + customer +
        ", number='" + number.replaceFirst(".{12}$", "*") + '\'' +
        ", expireDate='" + expireDate + '\'' +
        ", createdTime=" + createdTime +
        '}';
  }
}
