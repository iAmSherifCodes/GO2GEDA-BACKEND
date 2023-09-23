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
    void registerDriver(){
        DriverRegisterUserRequest firstDriverUser = new DriverRegisterUserRequest();
        firstDriverUser.setEmail("cashgraphicx@gmail.com");
        firstDriverUser.setFirstName("Dey");
        firstDriverUser.setLastName("Play");
        firstDriverUser.setPhoneNumber("90787878");
        firstDriverUser.setPassword("deyplaypassword");

        RegisterUserResponse firstDriver = driverService.register(firstDriverUser);

        assertThat(firstDriver).isNotNull();
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
    void driverCanLoginUser(){
        DriverRegisterUserRequest firstDriver = new DriverRegisterUserRequest();
        firstDriver.setEmail("driverlogin@gmail.com");
        firstDriver.setFirstName("Dey");
        firstDriver.setLastName("Play");
        firstDriver.setPhoneNumber("90787878");
        firstDriver.setPassword("deyplaypassword");

        RegisterUserResponse firstCommuter = driverService.register(firstDriver);

        assertThat(firstCommuter).isNotNull();


        LoginRequest request = new LoginRequest();
        request.setEmail("driverlogin@gmail.com");
        request.setPassword("deyplaypassword");

        LoginResponse response = userService.login(request);

        assertThat(response).isNotNull();
    }



    @Test
    void loginWithWrongCredentials(){
        DriverRegisterUserRequest firstDriverUser = new DriverRegisterUserRequest();
        firstDriverUser.setEmail("deyplay3@gmail.com");
        firstDriverUser.setFirstName("Dey");
        firstDriverUser.setLastName("Play");
        firstDriverUser.setPhoneNumber("90787878");
        firstDriverUser.setPassword("deyplaypassword");

        RegisterUserResponse firstCommuter = driverService.register(firstDriverUser);

        assertThat(firstCommuter).isNotNull();

        LoginRequest request = new LoginRequest();
        request.setEmail("deyplay3@gmail.com");
        request.setPassword("deyplaypassworded");

        assertThrows(UserNotFound.class, ()->userService.login(request));

        assertThatThrownBy(()->userService.login(request)).isInstanceOf(UserNotFound.class).hasMessage(USER_NOT_FOUND.name());
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

    @Test
    void verifyDriverAccountDetails(){
        DriverRegisterUserRequest driverRegisterUserRequest = new DriverRegisterUserRequest();
        driverRegisterUserRequest.setEmail("verifyDriverAccountdetails@gmail.com");
        driverRegisterUserRequest.setFirstName("Dey");
        driverRegisterUserRequest.setLastName("Play");
        driverRegisterUserRequest.setPhoneNumber("90787878");
        driverRegisterUserRequest.setPassword("deyplaypassword");

        driverService.register(driverRegisterUserRequest);


        String bankVerificationNUmber = "1212121212121";
        String accountNUmber = "1234567890";
        String bankName = "Go2Geda Bank PLC.";

//        User user = userService.findUserByEmail("verifyDriverAccountdetails@gmail.com");

//        Driver foundDriver = userService.findDriverByUser(user);


        AccountDetailsVerificationRequest request = new AccountDetailsVerificationRequest();
        request.setAccountNUmber(accountNUmber);
        request.setBankName(bankName);
        request.setBankVerificationNUmber(bankVerificationNUmber);
//        log.info(String.valueOf(user.getId()));


//        OkResponse response = driverService.verifyDriverAccountDetails(request, foundDriver.getId());

//        assertThat(response).isNotNull();
    }

    @Test
    void verifyCommuterAddress(){
        CommuterRegisterUserRequest firstCommuterUser = new CommuterRegisterUserRequest();
        firstCommuterUser.setEmail("verifycommuteradress@gmail.com");
        firstCommuterUser.setFirstName("Dey");
        firstCommuterUser.setLastName("Play");
        firstCommuterUser.setPhoneNumber("90787878");
        firstCommuterUser.setPassword("deyplaypassword");

        commuterService.register(firstCommuterUser);

        String address = "13 ST. Jones";

        AddressVerificationRequest request = new AddressVerificationRequest();
        request.setAddress(address);

//        User user = userService.findUserByEmail("verifycommuteradress@gmail.com");

//        Commuter foundDriver = userService.findCommuterByUser(user);


//        OkResponse response = userService.verifyAddress(request, foundDriver.getId());

//        assertThat(response).isNotNull();
    }
}
