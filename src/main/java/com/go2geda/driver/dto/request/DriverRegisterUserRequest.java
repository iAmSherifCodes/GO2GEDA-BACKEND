package com.go2geda.driver.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DriverRegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
