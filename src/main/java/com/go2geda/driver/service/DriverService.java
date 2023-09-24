package com.go2geda.driver.service;

import com.go2geda.driver.data.model.Driver;
import com.go2geda.driver.dto.request.AccountDetailsVerificationRequest;
import com.go2geda.driver.dto.request.DriverLicenceVerificationRequest;
import com.go2geda.driver.dto.request.DriverRegisterUserRequest;
import com.go2geda.user.dto.response.OkResponse;
import com.go2geda.user.dto.response.RegisterUserResponse;
import com.go2geda.user.service.UserService;
import org.springframework.web.multipart.MultipartFile;

public interface DriverService extends UserService {
    RegisterUserResponse register(DriverRegisterUserRequest request);
//    OkResponse verifyDriverAccountDetails(AccountDetailsVerificationRequest accountDetailsVerificationRequest, Long userId);
    Driver findDriverByEmail(String email);
    OkResponse verifyDriverAccountDetails(AccountDetailsVerificationRequest accountDetailsVerificationRequest, String email);
    OkResponse verifyDriverLicense(DriverLicenceVerificationRequest driverLicenceVerificationRequest);

}
