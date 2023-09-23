package com.go2geda.service;

import com.go2geda.data.model.BasicInformation;
import com.go2geda.data.model.Commuter;
import com.go2geda.data.model.Driver;
import com.go2geda.data.model.User;
import com.go2geda.dto.request.*;
import com.go2geda.dto.response.LoginResponse;
import com.go2geda.dto.response.OkResponse;
import com.go2geda.dto.response.RegisterUserResponse;
import com.go2geda.exception.UserNotFound;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.go2geda.exception.ExceptionMessage.USER_NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Slf4j
public class UserServiceTest {


    private final UserService userService;
    private final CommuterService commuterService;
    private final DriverService driverService;

    @Autowired
    public UserServiceTest(UserService userService, CommuterService commuterService, DriverService driverService) {
        this.userService = userService;
        this.commuterService = commuterService;
        this.driverService = driverService;
    }

    @Test
    void registerCommuter(){
        CommuterRegisterUserRequest firstCommuterUser = new CommuterRegisterUserRequest();
        firstCommuterUser.setEmail("gimivo5293@alvisani.com");
        firstCommuterUser.setFirstName("Dey");
        firstCommuterUser.setLastName("Play");
        firstCommuterUser.setPhoneNumber("90787878");
        firstCommuterUser.setPassword("deyplaypassword");
        RegisterUserResponse firstCommuter = commuterService.register(firstCommuterUser);

        assertThat(firstCommuter).isNotNull();
    }
    @Test
    void commuterCanLoginUser(){
        CommuterRegisterUserRequest firstCommuterUser = new CommuterRegisterUserRequest();
        firstCommuterUser.setEmail("commuterlogin@gmail.com");
        firstCommuterUser.setFirstName("Dey");
        firstCommuterUser.setLastName("Play");
        firstCommuterUser.setPhoneNumber("90787878");
        firstCommuterUser.setPassword("deyplaypassword");

        RegisterUserResponse firstCommuter = commuterService.register(firstCommuterUser);

        assertThat(firstCommuter).isNotNull();


        LoginRequest request = new LoginRequest();
        request.setEmail("commuterlogin@gmail.com");
        request.setPassword("deyplaypassword");

        LoginResponse response = userService.login(request);

        assertThat(response).isNotNull();
    }


    @Test
    void findUserByEmailTest(){
        CommuterRegisterUserRequest request = new CommuterRegisterUserRequest();
        request.setEmail("email@email.com");
        request.setFirstName("Dey");
        request.setLastName("Play");
        request.setPhoneNumber("90787878");
        request.setPassword("deyplaypassword");

        commuterService.register(request);

        BasicInformation foundUSer = userService.findUserByEmail("email@email.com");

        assertThat(foundUSer.getId()).isNotNull();
    }

//    @Test
//    void verifyCommuterAddress(){
//        CommuterRegisterUserRequest firstCommuterUser = new CommuterRegisterUserRequest();
//        firstCommuterUser.setEmail("verifycommuteradress@gmail.com");
//        firstCommuterUser.setFirstName("Dey");
//        firstCommuterUser.setLastName("Play");
//        firstCommuterUser.setPhoneNumber("90787878");
//        firstCommuterUser.setPassword("deyplaypassword");
//
//        commuterService.register(firstCommuterUser);
//
//        String address = "13 ST. Jones";
//
//        AddressVerificationRequest request = new AddressVerificationRequest();
//        request.setAddress(address);
//
////        User user = userService.findUserByEmail("verifycommuteradress@gmail.com");
//
////        Commuter foundDriver = userService.findCommuterByUser(user);
//
//
////        OkResponse response = userService.verifyAddress(request, foundDriver.getId());
//
////        assertThat(response).isNotNull();
//    }
}
