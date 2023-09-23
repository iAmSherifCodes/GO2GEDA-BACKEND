package com.go2geda.service;

import com.go2geda.data.model.BasicInformation;
import com.go2geda.data.model.Commuter;
import com.go2geda.data.model.Driver;
import com.go2geda.data.model.User;
import com.go2geda.dto.request.*;
import com.go2geda.dto.response.LoginResponse;
import com.go2geda.dto.response.OkResponse;
import com.go2geda.dto.response.RegisterUserResponse;

public interface UserService {
    LoginResponse login(LoginRequest loginRequest);
    BasicInformation findUserByEmail(String email);
    OkResponse verifyAddress(AddressVerificationRequest addressVerificationRequest, Long userId);
    OkResponse verifyDriverLicense(DriverLicenceVerificationRequest driverLicenceVerificationRequest);

}
