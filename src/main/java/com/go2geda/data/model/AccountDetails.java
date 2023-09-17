package com.go2geda.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@Document
public class AccountDetails {
    @Id
    private String id;
    private String bankVerificationNUmber;
    private String accountNUmber;
    private String bankName;
}
