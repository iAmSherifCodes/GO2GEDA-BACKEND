package com.go2geda.service;

import com.go2geda.commuter.service.CommuterService;
import com.go2geda.driver.service.DriverService;
import com.go2geda.commuter.dto.request.CommuterRegisterUserRequest;
import com.go2geda.user.dto.response.RegisterUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class UserServiceTest {



    private final CommuterService commuterService;
    private final DriverService driverService;

    @Autowired
    public UserServiceTest(CommuterService commuterService, DriverService driverService) {

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
