package com.go2geda.service;

import com.go2geda.data.model.AccountDetails;
import com.go2geda.data.model.Driver;
import com.go2geda.data.model.DriversProfile;
import com.go2geda.data.model.User;
import com.go2geda.data.repositories.DriverRepository;
import com.go2geda.data.repositories.UserRepository;
import com.go2geda.dto.request.AccountDetailsVerificationRequest;
import com.go2geda.dto.request.DriverRegisterUserRequest;
import com.go2geda.dto.response.OkResponse;
import com.go2geda.dto.response.RegisterUserResponse;
import com.go2geda.enums.Role;
import com.go2geda.exception.UserNotFound;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.go2geda.dto.response.ResponseMessage.REGISTRATION_SUCCESSFUL;
import static com.go2geda.exception.ExceptionMessage.USER_NOT_FOUND;
import static com.go2geda.utils.AppUtils.VERIFICATION_SUCCESSFUL;

@Service @AllArgsConstructor
public class Go2gedaDriverService implements DriverService{


    private final UserRepository userRepository;
    private final DriverRepository driverRepository;

    @Override
    public RegisterUserResponse register(DriverRegisterUserRequest request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String password = request.getPassword();
        String phoneNumber = request.getPhoneNumber();

        User newUser = new User();
        newUser.setRole(Role.DRIVER);


        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setPhoneNumber(phoneNumber);

        User savedUser = userRepository.save(newUser);

        Driver newDriver = new Driver();
        newDriver.setUser(savedUser);

        driverRepository.save(newDriver);
//        EmailSenderRequest emailSenderRequest = buildEmailRequest(savedUser);
//        mailService.send(emailSenderRequest);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage(REGISTRATION_SUCCESSFUL.name());


        return response;
    }

    @Override
    public Driver findDriverByUser(User user) {
        return null;
    }

    @Override
    public OkResponse verifyDriverAccountDetails(AccountDetailsVerificationRequest accountDetailsVerificationRequest, Long userId) {
        Driver foundDriver = driverRepository.findById(userId).orElseThrow(()->new UserNotFound(USER_NOT_FOUND.name()));

        DriversProfile profile = new DriversProfile();

        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAccountNUmber(accountDetailsVerificationRequest.getAccountNUmber());
        accountDetails.setBankName(accountDetailsVerificationRequest.getBankName());
        accountDetails.setBankVerificationNUmber(accountDetailsVerificationRequest.getBankVerificationNUmber());

        profile.setAccountDetails(accountDetails);
        foundDriver.setProfile(profile);

        OkResponse okResponse = new OkResponse();
        okResponse.setMessage(VERIFICATION_SUCCESSFUL);
        return okResponse;
    }
}
