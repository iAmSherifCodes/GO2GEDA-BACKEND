package com.go2geda.service;

import com.go2geda.data.repositories.UserRepository;
import com.go2geda.dto.request.AccountDetailsVerificationRequest;
import com.go2geda.dto.request.CommuterRegisterUserRequest;
import com.go2geda.dto.request.DriverRegisterUserRequest;
import com.go2geda.dto.request.LoginRequest;
import com.go2geda.dto.response.LoginResponse;
import com.go2geda.dto.response.OkResponse;
import com.go2geda.dto.response.RegisterUserResponse;
import com.go2geda.exception.UserNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import static com.go2geda.exception.ExceptionMessage.USER_NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserServiceTest(UserService userService) {
        this.userService = userService;
    }

//    RegisterUserResponse firstCommuter;
//    @BeforeEach
//    void setUp(){
//        CommuterRegisterUserRequest firstCommuterUser = new CommuterRegisterUserRequest();
//        firstCommuterUser.setEmail("setup@gmail.com");
//        firstCommuterUser.setFirstName("Dey");
//        firstCommuterUser.setLastName("Play");
//        firstCommuterUser.setPhoneNumber("90787878");
//        firstCommuterUser.setPassword("deyplaypassword");
//
//         firstCommuter = userService.register(firstCommuterUser);
//
////        assertThat(firstCommuter).isNotNull();
//    }

    @Test
    void registerCommuter(){
        CommuterRegisterUserRequest firstCommuterUser = new CommuterRegisterUserRequest();
        firstCommuterUser.setEmail("gimivo5293@alvisani.com");
        firstCommuterUser.setFirstName("Dey");
        firstCommuterUser.setLastName("Play");
        firstCommuterUser.setPhoneNumber("90787878");
        firstCommuterUser.setPassword("deyplaypassword");
        RegisterUserResponse firstCommuter = userService.register(firstCommuterUser);

        assertThat(firstCommuter).isNotNull();
    }

    @Test
    void registerDriver(){
        DriverRegisterUserRequest firstDriverUser = new DriverRegisterUserRequest();
        firstDriverUser.setEmail("deyplay1@gmail.com");
        firstDriverUser.setFirstName("Dey");
        firstDriverUser.setLastName("Play");
        firstDriverUser.setPhoneNumber("90787878");
        firstDriverUser.setPassword("deyplaypassword");

        RegisterUserResponse firstDriver = userService.register(firstDriverUser);

        assertThat(firstDriver).isNotNull();
    }

    @Test
    void loginUser(){
        CommuterRegisterUserRequest firstCommuterUser = new CommuterRegisterUserRequest();
        firstCommuterUser.setEmail("deyplay2@gmail.com");
        firstCommuterUser.setFirstName("Dey");
        firstCommuterUser.setLastName("Play");
        firstCommuterUser.setPhoneNumber("90787878");
        firstCommuterUser.setPassword("deyplaypassword");

        RegisterUserResponse firstCommuter = userService.register(firstCommuterUser);

        assertThat(firstCommuter).isNotNull();


        LoginRequest request = new LoginRequest();
        request.setEmail("deyplay2@gmail.com");
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

        RegisterUserResponse firstCommuter = userService.register(firstDriverUser);

        assertThat(firstCommuter).isNotNull();

        LoginRequest request = new LoginRequest();
        request.setEmail("deyplay3@gmail.com");
        request.setPassword("deyplaypassworded");

        assertThrows(UserNotFound.class, ()->userService.login(request));

        assertThatThrownBy(()->userService.login(request)).isInstanceOf(UserNotFound.class).hasMessage(USER_NOT_FOUND.name());
    }

    @Test
    void verifyAccountDetails(){
        CommuterRegisterUserRequest firstCommuterUser = new CommuterRegisterUserRequest();
        firstCommuterUser.setEmail("setup@gmail.com");
        firstCommuterUser.setFirstName("Dey");
        firstCommuterUser.setLastName("Play");
        firstCommuterUser.setPhoneNumber("90787878");
        firstCommuterUser.setPassword("deyplaypassword");

        userService.register(firstCommuterUser);


        String bankVerificationNUmber = "1212121212121";
        String accountNUmber = "1234567890";
        String bankName = "Go2Geda Bank PLC.";

        AccountDetailsVerificationRequest request = new AccountDetailsVerificationRequest();
        request.setAccountNUmber(accountNUmber);
        request.setBankName(bankName);
        request.setBankVerificationNUmber(bankVerificationNUmber);



        OkResponse response = userService.verifyAccountDetails(request, 1L);

        assertThat(response).isNotNull();


            }
}
