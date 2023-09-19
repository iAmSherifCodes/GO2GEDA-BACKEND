package com.go2geda.dto.request;

import com.go2geda.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommuterRegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Role role;
    private String password;
}
