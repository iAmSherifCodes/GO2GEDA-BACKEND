package com.go2geda.service;

import com.go2geda.dto.request.*;
import com.go2geda.dto.response.LoginResponse;
import com.go2geda.dto.response.OkResponse;
import com.go2geda.dto.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(CommuterRegisterUserRequest request);
    RegisterUserResponse register(DriverRegisterUserRequest request);
    LoginResponse login(LoginRequest loginRequest);
    OkResponse verifyAccountDetails(AccountDetailsVerificationRequest accountDetailsVerificationRequest, Long userId);
    OkResponse verifyAddress(AddressVerificationRequest addressVerificationRequest);
    OkResponse verifyDriverLicense(DriverLicenceVerificationRequest driverLicenceVerificationRequest);

}
