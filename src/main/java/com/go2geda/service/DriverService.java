package com.go2geda.service;

import com.go2geda.data.model.Driver;
import com.go2geda.data.model.User;
import com.go2geda.dto.request.AccountDetailsVerificationRequest;
import com.go2geda.dto.request.DriverRegisterUserRequest;
import com.go2geda.dto.response.OkResponse;
import com.go2geda.dto.response.RegisterUserResponse;

public interface DriverService {
    RegisterUserResponse register(DriverRegisterUserRequest request);
//    OkResponse verifyDriverAccountDetails(AccountDetailsVerificationRequest accountDetailsVerificationRequest, Long userId);
    Driver findDriverByEmail(String email);
    Driver findDriverById(Long driverId);
    OkResponse verifyDriverAccountDetails(AccountDetailsVerificationRequest accountDetailsVerificationRequest, String email);

}
