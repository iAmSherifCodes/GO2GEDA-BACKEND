package com.go2geda.service;

import com.go2geda.commuter.service.CommuterService;
import com.go2geda.commuter.dto.request.CommuterRegisterUserRequest;
import com.go2geda.driver.dto.request.DriverRegisterUserRequest;
import com.go2geda.driver.service.DriverService;
import com.go2geda.user.data.model.User;
import com.go2geda.user.dto.response.RegisterUserResponse;
import com.go2geda.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class UserServiceTest {



    private final CommuterService commuterService;


    private final UserService userService;
    private final DriverService driverService;

    @Autowired
    public UserServiceTest(CommuterService commuterService, @Qualifier("go2GedaUserService") UserService userService, DriverService driverService) {

        this.commuterService = commuterService;
        this.userService = userService;
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

        User foundUser = userService.findUserByEmail("gimivo5293@alvisani.com");
        assertThat(foundUser).isNotNull();
    }

    @Test
    void testFindUserByEmail(){
        DriverRegisterUserRequest firstDriverUser = new DriverRegisterUserRequest();
        firstDriverUser.setEmail("cashgraphicx@gmail.com");
        firstDriverUser.setFirstName("Sherif");
        firstDriverUser.setLastName("Pla");
        firstDriverUser.setPhoneNumber("90787878");
        firstDriverUser.setPassword("deyplaypassword");

        RegisterUserResponse firstDriver = driverService.register(firstDriverUser);

        assertThat(firstDriver).isNotNull();

        User foundUser = userService.findUserByEmail("cashgraphicx@gmail.com");
        assertThat(foundUser).isNotNull();

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



}
