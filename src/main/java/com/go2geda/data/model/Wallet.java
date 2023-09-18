package com.go2geda.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Wallet {
    @Id
    private Long id;
    private BigDecimal balance;
}
