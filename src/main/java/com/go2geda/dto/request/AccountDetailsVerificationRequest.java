package com.go2geda.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AccountDetailsVerificationRequest {
    private String bankVerificationNUmber;
    private String accountNUmber;
    private String bankName;
}
