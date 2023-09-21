package com.go2geda.service;

import com.go2geda.appConfig.AppConfig;
import com.go2geda.data.model.Commuter;
import com.go2geda.data.model.Driver;
import com.go2geda.data.model.User;
import com.go2geda.data.repositories.CommuterRepository;
import com.go2geda.data.repositories.DriverRepository;
import com.go2geda.data.repositories.UserRepository;
import com.go2geda.dto.request.*;
import com.go2geda.dto.response.LoginResponse;
import com.go2geda.dto.response.OkResponse;
import com.go2geda.dto.response.RegisterUserResponse;
import com.go2geda.enums.Role;
import com.go2geda.exception.UserNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.go2geda.appConfig.AppConfig.*;
import static com.go2geda.dto.response.ResponseMessage.LOGIN_SUCCESSFUL;
import static com.go2geda.dto.response.ResponseMessage.REGISTRATION_SUCCESSFUL;
import static com.go2geda.exception.ExceptionMessage.USER_NOT_FOUND;
import static com.go2geda.utils.AppUtils.generateActivationLink;
import static com.go2geda.utils.AppUtils.getMailTemplate;
import static com.go2geda.utils.JwtUtils.generateVerificationToken;

@Service
@RequiredArgsConstructor
@Slf4j
public class Go2GedaUserService implements UserService{

    private final UserRepository userRepository;
    private final CommuterRepository commuterRepository;
    private final DriverRepository driverRepository;

    private final AppConfig appConfig;
    private final MailService mailService;

    @Override
    public RegisterUserResponse register(CommuterRegisterUserRequest request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String password = request.getPassword();
        String phoneNumber = request.getPhoneNumber();

        User newUser = new User();

        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setPhoneNumber(phoneNumber);

        log.info(firstName);
        newUser.setRole(Role.COMMUTER);
        User savedUser = userRepository.save(newUser);

        Commuter newCommuter = new Commuter();
        newCommuter.setUser(savedUser);

        Commuter savedCommuter = commuterRepository.save(newCommuter);
        EmailSenderRequest emailSenderRequest = buildEmailRequest(savedUser);
        mailService.send(emailSenderRequest);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage(REGISTRATION_SUCCESSFUL.name());

        return response;
    }

    private EmailSenderRequest buildEmailRequest(User savedUser){
        EmailSenderRequest request =new EmailSenderRequest();
        List<MailInfo> recipients = new ArrayList<>();
        MailInfo recipient = new MailInfo(savedUser.getFirstName() + SPACE + savedUser.getLastName(), savedUser.getEmail());
        recipients.add(recipient);
        request.setTo(recipients);
        request.setSubject(WELCOME_MAIL_SUBJECT);
        String activationLink =
                generateActivationLink(appConfig.getBaseUrl(), savedUser.getEmail());
        String emailTemplate = getMailTemplate();
        String mailContent = String.format(emailTemplate, activationLink);
        request.setHtmlContent(mailContent);
        return request;
    }




    @Override
    public RegisterUserResponse register(DriverRegisterUserRequest request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String password = request.getPassword();
        String phoneNumber = request.getPhoneNumber();

        User newUser = new User();
        newUser.setRole(Role.DRIVER);


//        User newUser =

        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setPhoneNumber(phoneNumber);

        User savedUser = userRepository.save(newUser);

        log.info(firstName);

        Driver newDriver = new Driver();
        newDriver.setUser(savedUser);

        driverRepository.save(newDriver);
//        EmailSenderRequest emailSenderRequest = buildEmailRequest(savedUser);
//        mailService.send(emailSenderRequest);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage(REGISTRATION_SUCCESSFUL.name());


        return response;
    }

//    private static User map(String firstName, String lastName, String email, String password, String phoneNumber) {
//        User newUser = new User();
//
//        newUser.setFirstName(firstName);
//        newUser.setLastName(lastName);
//        newUser.setEmail(email);
//        newUser.setPassword(password);
//        newUser.setPhoneNumber(phoneNumber);
//
//        return newUser;
//    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        User foundUser = userRepository.findByEmail(email).filter(user->user.getPassword().equals(password)).orElseThrow(()->new UserNotFound(USER_NOT_FOUND.name()));

        log.info(String.valueOf(foundUser.getRole()));
        LoginResponse response = new LoginResponse();
        response.setMessage(LOGIN_SUCCESSFUL.name());
        return response;

    }

    @Override
    public OkResponse verifyAccountDetails(AccountDetailsVerificationRequest accountDetailsVerificationRequest, Long userId) {
        return null;
    }

    @Override
    public OkResponse verifyAddress(AddressVerificationRequest addressVerificationRequest) {
        return null;
    }

    @Override
    public OkResponse verifyDriverLicense(DriverLicenceVerificationRequest driverLicenceVerificationRequest) {
        return null;
    }
}

