package com.go2geda.driverTest;

import com.go2geda.appConfig.AppConfig;
import com.go2geda.driver.data.model.Driver;
import com.go2geda.driver.dto.request.AccountDetailsVerificationRequest;
import com.go2geda.driver.dto.request.DriverLicenceVerificationRequest;
import com.go2geda.driver.dto.request.DriverRegisterUserRequest;
import com.go2geda.driver.service.DriverService;
import com.go2geda.user.dto.request.AddressVerificationRequest;
import com.go2geda.user.dto.request.LoginRequest;
import com.go2geda.user.dto.response.OkResponse;
import com.go2geda.user.dto.response.RegisterUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest @Slf4j
public class DriverServiceTest {

    private final DriverService driverService;
    private final AppConfig appConfig;

    @Autowired
    public DriverServiceTest(DriverService driverService, AppConfig appConfig) {
        this.driverService = driverService;
        this.appConfig = appConfig;
    }

    @Test
    void registerDriver(){
        DriverRegisterUserRequest firstDriverUser = new DriverRegisterUserRequest();
        firstDriverUser.setEmail("cashgraphicx@gmail.com");
        firstDriverUser.setFirstName("Sherif");
        firstDriverUser.setLastName("Play");
        firstDriverUser.setPhoneNumber("90787878");
        firstDriverUser.setPassword("deyplaypassword");

        RegisterUserResponse firstDriver = driverService.register(firstDriverUser);

        assertThat(firstDriver).isNotNull();
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

//        LoginResponse response = userService.login(request);
//
//        assertThat(response).isNotNull();
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

//        assertThrows(UserNotFound.class, ()->userService.login(request));
//
//        assertThatThrownBy(()->userService.login(request)).isInstanceOf(UserNotFound.class).hasMessage(USER_NOT_FOUND.name());
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

        String bankVerificationNUmber = "1212121212";
        String accountNUmber = "1234567890";
        String bankName = "Go2Geda Bank PLC.";

        AccountDetailsVerificationRequest verificationRequest = new AccountDetailsVerificationRequest();
        verificationRequest.setAccountNUmber(accountNUmber);
        verificationRequest.setBankName(bankName);
        verificationRequest.setBankVerificationNUmber(bankVerificationNUmber);

        Driver foundDriver = driverService.findDriverByEmail("verifyDriverAccountdetails@gmail.com");
        log.info(foundDriver.toString());

        String email = foundDriver.getUser().getBasicInformation().getEmail();

        OkResponse response = driverService.verifyDriverAccountDetails(verificationRequest, email);

        assertThat(response).isNotNull();
    }

    @Test
    void verifyDriverAddress(){
        DriverRegisterUserRequest registerUserRequest = new DriverRegisterUserRequest();
        registerUserRequest.setEmail("verifydriveradress@gmail.com");
        registerUserRequest.setFirstName("Dey");
        registerUserRequest.setLastName("Play");
        registerUserRequest.setPhoneNumber("90787878");
        registerUserRequest.setPassword("deyplaypassword");

        driverService.register(registerUserRequest);

        String address = "13 ST. Jones";
        String localGovernment = "Yaba";
        String state = "Lagos";

        AddressVerificationRequest request = new AddressVerificationRequest();
        request.setHomeAddress(address);
        request.setState(state);
        request.setLocalGovernment(localGovernment);

        OkResponse response = driverService.verifyAddress(request,  "verifydriveradress@gmail.com");

        assertThat(response).isNotNull();
    }

    @Test
    void verifyDriverLicenseTest(){
        String frontPicture = appConfig.getDriverLicenseFrontPictureTest();

        String backPicture = appConfig.getDriverLicenseBackPictureTest();

        Path pathOne = Paths.get("C:\\Users\\SHERIF\\IdeaProjects\\GO2GEDA-BACKEND\\GO2GEDA\\src\\main\\resources\\static\\assets\\Driver-licence-front.jpg");
        Path pathTwo = Paths.get("C:\\Users\\SHERIF\\IdeaProjects\\GO2GEDA-BACKEND\\GO2GEDA\\src\\main\\resources\\static\\assets\\drivers-license-back.jpg");

        try {
            InputStream inputStream = Files.newInputStream(pathOne);
            InputStream inputStream2 = Files.newInputStream(pathTwo);

            MultipartFile multipartFrontFile = new MockMultipartFile("test",inputStream);
            MultipartFile multipartBackFile = new MockMultipartFile("test",inputStream2);

            DriverLicenceVerificationRequest verificationRequest = new DriverLicenceVerificationRequest();
            verificationRequest.setFrontPicture(multipartFrontFile);
            verificationRequest.setBackPicture(multipartBackFile);

            OkResponse uploadedVideo = driverService.verifyDriverLicense(verificationRequest);
            assertThat(uploadedVideo).isNotNull();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }





    }
}
