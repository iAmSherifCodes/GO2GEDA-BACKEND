package com.go2geda.user.service;

import com.go2geda.appConfig.AppConfig;
import com.go2geda.user.data.model.Address;
import com.go2geda.user.data.model.User;
import com.go2geda.user.data.repository.AddressRepository;
import com.go2geda.user.data.repository.BasicInformationRepository;
import com.go2geda.commuter.data.repositories.CommuterRepository;
import com.go2geda.user.data.repository.UserRepository;
import com.go2geda.driver.data.repository.DriverRepository;
import com.go2geda.user.dto.request.AddressVerificationRequest;
import com.go2geda.user.dto.response.OkResponse;
import com.go2geda.utils.exception.UserNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.go2geda.user.dto.response.ResponseMessage.ACCOUNT_ACTIVATED;
import static com.go2geda.user.dto.response.ResponseMessage.REGISTRATION_SUCCESSFUL;
import static com.go2geda.utils.exception.ExceptionMessage.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class Go2GedaUserService implements UserService{

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

//    private User findUserById(Long id){
//        return userRepository.findById(id).orElseThrow(()->new UserNotFound(USER_NOT_FOUND.name()));
//    }


    @Override
    public OkResponse verifyAddress(AddressVerificationRequest addressVerificationRequest, String userEmail) {
//        String address = addressVerificationRequest.getHomeAddress();
//        String state = addressVerificationRequest.getState();
//        String localG = addressVerificationRequest.getLocalGovernment();
//
//        Address newAddress = new Address();
//        newAddress.setHomeAddress(address);
//        newAddress.setState(state);
//        newAddress.setLocalGovernment(localG);
//
//        Address savedAddress = addressRepository.save(newAddress);
//        User foundUser = findUserById(userId);
//        foundUser.setAddress(savedAddress);
//
//        userRepository.save(foundUser);


        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(()->new UserNotFound(USER_NOT_FOUND.name()));
    }

    @Override
    public OkResponse activateAccount(String email) {
        User foundUser = findUserByEmail(email);
        foundUser.setActive(true);
        OkResponse response = new OkResponse();
        response.setMessage(ACCOUNT_ACTIVATED.name());
        return response;
    }


}

