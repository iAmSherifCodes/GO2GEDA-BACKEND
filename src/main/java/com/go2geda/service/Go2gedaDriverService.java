package com.go2geda.service;

import com.go2geda.data.model.*;
import com.go2geda.data.repositories.BasicInformationRepository;
import com.go2geda.data.repositories.DriverRepository;
import com.go2geda.data.repositories.UserRepository;
import com.go2geda.dto.request.AccountDetailsVerificationRequest;
import com.go2geda.dto.request.DriverRegisterUserRequest;
import com.go2geda.dto.request.EmailSenderRequest;
import com.go2geda.dto.request.MailInfo;
import com.go2geda.dto.response.OkResponse;
import com.go2geda.dto.response.RegisterUserResponse;
import com.go2geda.enums.Role;
import com.go2geda.exception.UserNotFound;
import com.go2geda.utils.BuildEmailRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.go2geda.appConfig.AppConfig.SPACE;
import static com.go2geda.appConfig.AppConfig.WELCOME_MAIL_SUBJECT;
import static com.go2geda.dto.response.ResponseMessage.REGISTRATION_SUCCESSFUL;
import static com.go2geda.exception.ExceptionMessage.USER_NOT_FOUND;
import static com.go2geda.utils.AppUtils.*;

@Service @AllArgsConstructor
public class Go2gedaDriverService implements DriverService{


    private final UserRepository userRepository;
    private final DriverRepository driverRepository;
    private final BasicInformationRepository basicInformationRepository;

    private final BuildEmailRequest buildEmailRequest;
    private final MailService mailService;

    @Override
    public RegisterUserResponse register(DriverRegisterUserRequest request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String password = request.getPassword();
        String phoneNumber = request.getPhoneNumber();

        User newUser = new User();
        newUser.setRole(Role.DRIVER);

        BasicInformation basicInformation =new BasicInformation();

        basicInformation.setFirstName(firstName);
        basicInformation.setLastName(lastName);
        basicInformation.setEmail(email);
        basicInformation.setPassword(password);
        basicInformation.setPhoneNumber(phoneNumber);

//        BasicInformation savedInfo = basicInformationRepository.save(basicInformation);


        User savedUser = userRepository.save(newUser);

        savedUser.setBasicInformation(basicInformation);
        Driver newDriver = new Driver();
        newDriver.setUser(savedUser);

        driverRepository.save(newDriver);
        EmailSenderRequest emailSenderRequest = buildEmailRequest.buildEmailRequest(basicInformation);
        mailService.send(emailSenderRequest);

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

        DriverInformation profile = new DriverInformation();

        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAccountNUmber(accountDetailsVerificationRequest.getAccountNUmber());
        accountDetails.setBankName(accountDetailsVerificationRequest.getBankName());
        accountDetails.setBankVerificationNUmber(accountDetailsVerificationRequest.getBankVerificationNUmber());

        profile.setAccountDetails(accountDetails);
//        foundDriver.setProfile(profile);

        OkResponse okResponse = new OkResponse();
        okResponse.setMessage(VERIFICATION_SUCCESSFUL);
        return okResponse;
    }

}
