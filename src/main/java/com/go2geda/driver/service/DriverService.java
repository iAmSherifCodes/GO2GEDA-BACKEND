package com.go2geda.driver.service;

import com.go2geda.driver.data.model.Driver;
import com.go2geda.driver.dto.request.AccountDetailsVerificationRequest;
import com.go2geda.driver.dto.request.DriverLicenceVerificationRequest;
import com.go2geda.driver.dto.request.DriverRegisterUserRequest;
import com.go2geda.user.dto.request.AddressVerificationRequest;
import com.go2geda.user.dto.response.OkResponse;
import com.go2geda.user.dto.response.RegisterUserResponse;
import com.go2geda.user.service.UserService;
import org.springframework.web.multipart.MultipartFile;

public interface DriverService {
    RegisterUserResponse register(DriverRegisterUserRequest request);
    Driver findDriverByEmail(String email);
    OkResponse verifyAddress(AddressVerificationRequest addressVerificationRequest, String email);
    OkResponse verifyDriverAccountDetails(AccountDetailsVerificationRequest accountDetailsVerificationRequest, String email);
    OkResponse verifyDriverLicense(DriverLicenceVerificationRequest driverLicenceVerificationRequest);

}
