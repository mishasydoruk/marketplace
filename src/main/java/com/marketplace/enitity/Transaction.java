package com.marketplace.enitity;

import com.marketplace.enums.AdvertisementStatus;
import com.marketplace.enums.TransactionStatus;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "credit_card_data_id", referencedColumnName = "id", nullable = false)
  private CreditCardData creditCardData;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "advertisement_id", nullable = false)
  private Advertisement advertisement;

  @Column(name = "reference_id")
  private String reference_id;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private TransactionStatus status;

  @Column(name = "created_time")
  private Instant createdTime = Instant.now();

  @Override
  public String toString() {
    return "Transaction{" +
        "id=" + id +
        ", reference_id='" + reference_id + '\'' +
        ", amount=" + amount +
        ", status=" + status +
        ", createdTime=" + createdTime +
        '}';
  }
}
