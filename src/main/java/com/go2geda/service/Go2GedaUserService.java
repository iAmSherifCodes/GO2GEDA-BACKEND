package com.go2geda.service;

import com.go2geda.appConfig.AppConfig;
import com.go2geda.data.model.*;
import com.go2geda.data.repositories.*;
import com.go2geda.dto.request.*;
import com.go2geda.dto.response.Go2gedaResponse;
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

    private User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFound(USER_NOT_FOUND.name()));
    }


    @Override
    public OkResponse verifyAddress(AddressVerificationRequest addressVerificationRequest, String userEmail) {
        String address = addressVerificationRequest.getHomeAddress();
        String state = addressVerificationRequest.getState();
        String localG = addressVerificationRequest.getLocalGovernment();

        Address newAddress = new Address();
        newAddress.setHomeAddress(address);
        newAddress.setState(state);
        newAddress.setLocalGovernment(localG);

        Address savedAddress = addressRepository.save(newAddress);
//        User foundUser = findUserById(userId);
//        foundUser.setAddress(savedAddress);
//
//        userRepository.save(foundUser);


        return null;
    }


}

