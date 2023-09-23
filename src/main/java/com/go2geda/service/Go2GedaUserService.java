package com.go2geda.service;

import com.go2geda.appConfig.AppConfig;
import com.go2geda.data.model.*;
import com.go2geda.data.repositories.*;
import com.go2geda.dto.request.*;
import com.go2geda.dto.response.LoginResponse;
import com.go2geda.dto.response.OkResponse;
import com.go2geda.dto.response.RegisterUserResponse;
import com.go2geda.enums.Role;
import com.go2geda.exception.UserNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.go2geda.appConfig.AppConfig.*;
import static com.go2geda.dto.response.ResponseMessage.LOGIN_SUCCESSFUL;
import static com.go2geda.dto.response.ResponseMessage.REGISTRATION_SUCCESSFUL;
import static com.go2geda.exception.ExceptionMessage.USER_NOT_FOUND;
import static com.go2geda.utils.AppUtils.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class Go2GedaUserService implements UserService{

    private final UserRepository userRepository;
    private final CommuterRepository commuterRepository;
    private final DriverRepository driverRepository;
    private final AddressRepository addressRepository;
    private final BasicInformationRepository basicInformationRepository;

    private final AppConfig appConfig;
    private final MailService mailService;



    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        //Todo
        // fix this method
        // fix this class

//        User foundUser = userRepository.findByEmail(email).filter(user->user.getPassword().equals(password)).orElseThrow(()->new UserNotFound(USER_NOT_FOUND.name()));

//        log.info(String.valueOf(foundUser.getRole()));
        LoginResponse response = new LoginResponse();
        response.setMessage(LOGIN_SUCCESSFUL.name());
        return response;

    }

    @Override
    public BasicInformation findUserByEmail(String email) {
        return basicInformationRepository.findByEmail(email).orElseThrow(()-> new UserNotFound(USER_NOT_FOUND.name()));
    }

    private User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFound(USER_NOT_FOUND.name()));
    }


    @Override
    public OkResponse verifyAddress(AddressVerificationRequest addressVerificationRequest, Long userId) {
        String address = addressVerificationRequest.getAddress();

        Address newAddress = new Address();
        newAddress.setHomeAddress(address);

        Address savedAddress = addressRepository.save(newAddress);
        User foundUser = findUserById(userId);
        foundUser.setAddress(savedAddress);

        userRepository.save(foundUser);


        return null;
    }

    @Override
    public OkResponse verifyDriverLicense(DriverLicenceVerificationRequest driverLicenceVerificationRequest) {
        return null;
    }


}

