package com.marketplace.enitity;

import com.marketplace.enums.TransactionStatus;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
  private String referenceId;

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
        ", referenceId='" + referenceId + '\'' +
        ", amount=" + amount +
        ", status=" + status +
        ", createdTime=" + createdTime +
        '}';
  }
}
