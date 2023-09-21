package com.go2geda.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 11)
    private String bankVerificationNUmber;
    @Column(length = 10)
    private String accountNUmber;
    private String bankName;
}
