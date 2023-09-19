package com.go2geda.service;

import com.go2geda.dto.request.DriverRegisterUserRequest;
import com.go2geda.dto.request.LoginRequest;
import com.go2geda.dto.request.CommuterRegisterUserRequest;
import com.go2geda.dto.response.LoginResponse;
import com.go2geda.dto.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(CommuterRegisterUserRequest request);
    RegisterUserResponse register(DriverRegisterUserRequest request);
    LoginResponse login(LoginRequest loginRequest);
}
