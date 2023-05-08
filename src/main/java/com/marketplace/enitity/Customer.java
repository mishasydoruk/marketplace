package com.marketplace.enitity;

import com.marketplace.enums.CustomerStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "phone")
  private String phone;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private CustomerStatus status;

  @Column(name = "created_time")
  private Instant createdTime = Instant.now();

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", status=" + status +
        ", createdTime=" + createdTime +
        '}';
  }
}
